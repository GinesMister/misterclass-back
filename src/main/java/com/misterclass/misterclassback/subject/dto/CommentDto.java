package com.misterclass.misterclassback.subject.dto;

import com.misterclass.misterclassback.user.dto.UserDto;
import jakarta.persistence.Entity;
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
