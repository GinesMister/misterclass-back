package com.misterclass.misterclassback.features.subject.model;

import com.misterclass.misterclassback.features.user.model.UserEntity;
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
@Table(name = "subject")
public class SubjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long subjectId;

    @Column(name = "color")
    private String color;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "teacher")
    private UserEntity teacher;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UnitEntity> units;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(
            name = "subject_student", joinColumns = @JoinColumn(name = "subject_id", referencedColumnName = "subjectId"),
            inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "userId")
    )
    private List<UserEntity> students;
}