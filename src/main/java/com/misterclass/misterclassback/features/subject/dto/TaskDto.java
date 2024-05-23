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
public class TaskDto {

    private long taskId;

    private String title;

    private String description;

    private List<CommentDto> comments;
}
