package com.misterclass.misterclassback.features.user.model;

import com.misterclass.misterclassback.features.subject.model.SubjectEntity;
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
@Table(name = "user")
public class UserEntity {

    @Id
    private String userId;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @ManyToMany(mappedBy = "students",
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    private List<SubjectEntity> subjectsSubscribed;

}
