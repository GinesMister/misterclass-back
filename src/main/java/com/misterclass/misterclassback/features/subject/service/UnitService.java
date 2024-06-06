package com.misterclass.misterclassback.features.subject.service;

import com.misterclass.misterclassback.exceptions.general.NotFoundException;
import com.misterclass.misterclassback.features.subject.dto.unit.UnitDto;
import com.misterclass.misterclassback.features.subject.mapper.SubjectMapper;
import com.misterclass.misterclassback.features.subject.mapper.UnitMapper;
import com.misterclass.misterclassback.features.subject.repository.SubjectRepository;
import com.misterclass.misterclassback.features.subject.repository.UnitRepository;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UnitService {

    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private SubjectMapper subjectMapper;
    @Autowired
    private UnitRepository unitRepository;
    @Autowired
    private UnitMapper unitMapper;

    public void createUnit(long subjectId, UnitDto unitDto) throws NotFoundException {
        var subjectToAddUnit = subjectRepository.findById(subjectId);
        if (subjectToAddUnit.isEmpty()) throw new NotFoundException();
        subjectToAddUnit.get().getUnits().add(unitMapper.dtoToEntity(unitDto));
        subjectRepository.save(subjectToAddUnit.get());
    }

    public void updateUnit (long unitId, UnitDto unit) throws NotFoundException {
        var unitToUpdate = unitRepository.findById(unitId);
        if (unitToUpdate.isEmpty()) throw new NotFoundException();
        unitToUpdate.get().setTitle(unit.getTitle());
        unitRepository.save(unitToUpdate.get());
    }

    public void deleteUnit(long unitId) throws NotFoundException {
        var unitToDelete = unitRepository.findById(unitId);
        if (unitToDelete.isEmpty()) throw new NotFoundException();
        unitRepository.delete(unitToDelete.get());
    }
}
