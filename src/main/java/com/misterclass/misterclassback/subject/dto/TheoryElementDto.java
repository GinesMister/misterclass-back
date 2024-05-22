package com.misterclass.misterclassback.subject.dto;

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

    private List<CommentDto> comments;
}
