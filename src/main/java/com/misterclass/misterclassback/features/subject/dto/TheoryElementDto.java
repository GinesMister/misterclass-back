package com.misterclass.misterclassback.features.subject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TheoryElementDto {

    private long theoryElementId;

    private String title;

    private String description;

    private String filename;

    private List<CommentDto> comments;
}
