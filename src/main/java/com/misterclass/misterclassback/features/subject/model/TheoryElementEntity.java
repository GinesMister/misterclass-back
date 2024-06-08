package com.misterclass.misterclassback.features.subject.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "theoryElement")
public class TheoryElementEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long theoryElementId;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="unit")
    private UnitEntity unit;

    private String filePath;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CommentEntity> comments;
}
