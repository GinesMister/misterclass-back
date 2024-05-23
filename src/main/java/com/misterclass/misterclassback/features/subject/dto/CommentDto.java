package com.misterclass.misterclassback.features.subject.dto;

import com.misterclass.misterclassback.features.user.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentDto {

    private long commentId;

    private String message;

    private LocalDate date;

    private UserDto sender;
}
