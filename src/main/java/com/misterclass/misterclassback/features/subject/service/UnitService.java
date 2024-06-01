package com.misterclass.misterclassback.features.subject.service;

import com.misterclass.misterclassback.features.subject.dto.unit.CreateUnitRequestDto;
import com.misterclass.misterclassback.features.subject.dto.unit.UnitDto;
import com.misterclass.misterclassback.features.subject.mapper.UnitMapper;
import com.misterclass.misterclassback.features.subject.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnitService {
    // TODO continuar
    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private UnitMapper unitMapper;

    public UnitDto createUnit(CreateUnitRequestDto newUnit) {

        return null;
    }
}
