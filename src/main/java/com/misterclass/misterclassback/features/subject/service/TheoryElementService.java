package com.misterclass.misterclassback.features.subject.service;

import com.misterclass.misterclassback.exceptions.general.NotFoundException;
import com.misterclass.misterclassback.features.subject.dto.TheoryElementDto;
import com.misterclass.misterclassback.features.subject.mapper.TheoryElementMapper;
import com.misterclass.misterclassback.features.subject.repository.TheoryElementRepository;
import com.misterclass.misterclassback.features.subject.repository.UnitRepository;
import com.misterclass.misterclassback.functions.EUploadRoots;
import com.misterclass.misterclassback.functions.HandleFiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class TheoryElementService {

    @Autowired
    private UnitRepository unitRepository;
    @Autowired
    private TheoryElementRepository theoryElementRepository;
    @Autowired
    private TheoryElementMapper theoryElementMapper;

    public void createTheoryElement(long unitId, TheoryElementDto theoryElement, MultipartFile file) throws NotFoundException, IOException {
        var unitToAddTheory = unitRepository.findById(unitId);
        if (unitToAddTheory.isEmpty()) throw new NotFoundException();
        unitToAddTheory.get().getTheoryElements().add(theoryElementMapper.dtoToEntity(theoryElement));

        var theoryElementEntity = theoryElementMapper.dtoToEntity(theoryElement);
        if (file.isEmpty()) {
            unitToAddTheory.get().getTheoryElements().add(theoryElementEntity);
            unitRepository.save(unitToAddTheory.get());
        }

        var theoryElementEntitySaved = theoryElementRepository.save(theoryElementEntity);
        String fileDir = Long.toString(theoryElementEntitySaved.getTheoryElementId());
        theoryElementEntitySaved.setFilename(HandleFiles.uploadFile(file, fileDir, EUploadRoots.THEORY_PATH));
        unitToAddTheory.get().getTheoryElements().add(theoryElementEntitySaved);
        unitRepository.save(unitToAddTheory.get());
        theoryElementRepository.save(theoryElementEntitySaved);
    }
}
