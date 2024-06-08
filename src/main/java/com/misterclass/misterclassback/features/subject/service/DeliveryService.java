package com.misterclass.misterclassback.features.subject.service;

import com.misterclass.misterclassback.exceptions.general.NotFoundException;
import com.misterclass.misterclassback.features.subject.dto.DeliveryDto;
import com.misterclass.misterclassback.features.subject.mapper.DeliveryMapper;
import com.misterclass.misterclassback.features.subject.mapper.TaskMapper;
import com.misterclass.misterclassback.features.subject.repository.DeliveryRepository;
import com.misterclass.misterclassback.features.subject.repository.TaskRepository;
import com.misterclass.misterclassback.features.user.repository.UserRepository;
import com.misterclass.misterclassback.functions.HandleFiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;

@Service
public class DeliveryService {

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TaskMapper taskMapper;
    @Autowired
    private DeliveryRepository deliveryRepository;
    @Autowired
    private DeliveryMapper deliveryMapper;

    public void createDelivery(long taskId, String delivererId, MultipartFile file) throws NotFoundException, IOException {
        var task = taskRepository.findById(taskId);
        if (task.isEmpty()) throw new NotFoundException();
        var deliverer = userRepository.findById(delivererId);
        if (deliverer.isEmpty()) throw new NotFoundException();

        var deliver = new DeliveryDto();
        deliver.setDeliveryDate(LocalDateTime.now());
        deliver.setDelivererId(delivererId);
        var deliverEntity = deliveryMapper.dtoToEntity(deliver);
        if (file.isEmpty()) {
            task.get().getDeliveries().add(deliverEntity);
            taskRepository.save(task.get());
            return;
        }

        deliverEntity.setFilePath(HandleFiles.uploadFile(file, Long.toString(taskId)));
        task.get().getDeliveries().add(deliverEntity);
        taskRepository.save(task.get());
    }
}
