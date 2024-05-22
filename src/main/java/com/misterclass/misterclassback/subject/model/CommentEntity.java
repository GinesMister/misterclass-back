package com.misterclass.misterclassback.subject.model;

import com.misterclass.misterclassback.user.model.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "comment")
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long commentId;

    @Column(name = "message")
    private String message;

    @Column(name = "date")
    private LocalDate date;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="user")
    private UserEntity sender;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "task_id")
    private TaskEntity task;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "theoryelement_id")
    private TheoryElementEntity theoryElement;
}