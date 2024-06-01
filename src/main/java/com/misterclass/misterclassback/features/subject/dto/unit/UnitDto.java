package com.misterclass.misterclassback.features.subject.dto.unit;

import com.misterclass.misterclassback.features.subject.dto.TheoryElementDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UnitDto {

    private long unitId;

    private String title;

    private String subtitle;

    private List<TheoryElementDto> theoryElements;
}
