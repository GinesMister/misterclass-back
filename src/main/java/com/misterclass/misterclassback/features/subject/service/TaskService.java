package com.misterclass.misterclassback.features.subject.service;

import com.misterclass.misterclassback.exceptions.general.NotFoundException;
import com.misterclass.misterclassback.features.subject.dto.TaskDto;
import com.misterclass.misterclassback.features.subject.mapper.SubjectMapper;
import com.misterclass.misterclassback.features.subject.mapper.TaskMapper;
import com.misterclass.misterclassback.features.subject.repository.SubjectRepository;
import com.misterclass.misterclassback.features.subject.repository.TaskRepository;
import com.misterclass.misterclassback.features.subject.repository.UnitRepository;
import com.misterclass.misterclassback.functions.EUploadRoots;
import com.misterclass.misterclassback.functions.HandleFiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class TaskService {
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private UnitRepository unitRepository;
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private SubjectMapper subjectMapper;
    @Autowired
    private TaskMapper taskMapper;

    public void createTask(long unitId, TaskDto task, MultipartFile file) throws NotFoundException, IOException {
        var unitToAddTask = unitRepository.findById(unitId);
        if (unitToAddTask.isEmpty()) throw new NotFoundException();

        var taskEntity = taskMapper.dtoToEntity(task);
        if (file.isEmpty()) {
            unitRepository.save(unitToAddTask.get());
        }

        var taskEntitySaved = taskRepository.save(taskEntity);

        String fileDir = Long.toString(taskEntitySaved.getTaskId());
        taskEntitySaved.setFilename(HandleFiles.uploadFile(file, fileDir, EUploadRoots.TASK_PATH));

        unitToAddTask.get().getTasks().add(taskEntitySaved);
        taskRepository.save(taskEntitySaved);
    }

    public void updateTask(long taskId, TaskDto task) throws NotFoundException {
        var taskToUpdate = taskRepository.findById(taskId);
        if (taskToUpdate.isEmpty()) throw new NotFoundException();
        taskToUpdate.get().setDescription(task.getDescription());
        taskToUpdate.get().setTitle(task.getTitle());
        taskRepository.save(taskToUpdate.get());
    }

    public void deleteTask(long taskId) throws NotFoundException {
        var taskToDelete = taskRepository.findById(taskId);
        if (taskToDelete.isEmpty()) throw new NotFoundException();
        taskRepository.delete(taskToDelete.get());
    }
}
