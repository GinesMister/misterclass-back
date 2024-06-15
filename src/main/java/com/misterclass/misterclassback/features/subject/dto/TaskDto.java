package com.misterclass.misterclassback.features.subject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskDto {

    private long taskId;

    private String title;

    private LocalDateTime deadline;

    private String filename;

    private String description;

    private List<DeliveryDto> deliveries;

    private List<CommentDto> comments;
}
