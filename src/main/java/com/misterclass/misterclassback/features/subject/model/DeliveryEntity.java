package com.misterclass.misterclassback.features.subject.model;

import com.misterclass.misterclassback.features.user.model.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "delivery")
public class DeliveryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long deliveryId;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "deliverer_id")
    private UserEntity deliverer;

    @Column(name = "file_path")
    private String filePath;

    @Column(name = "delivery_date")
    private LocalDateTime deliveryDate;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "task_id")
    private TaskEntity task;
}
