package com.misterclass.misterclassback.features.subject.service;

import com.misterclass.misterclassback.exceptions.general.NotFoundException;
import com.misterclass.misterclassback.features.subject.dto.TaskDto;
import com.misterclass.misterclassback.features.subject.dto.unit.UnitDto;
import com.misterclass.misterclassback.features.subject.mapper.SubjectMapper;
import com.misterclass.misterclassback.features.subject.mapper.TaskMapper;
import com.misterclass.misterclassback.features.subject.repository.SubjectRepository;
import com.misterclass.misterclassback.features.subject.repository.TaskRepository;
import com.misterclass.misterclassback.features.subject.repository.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void createTask(long unitId, TaskDto task) throws NotFoundException {
        var unitToAddTask = unitRepository.findById(unitId);
        if (unitToAddTask.isEmpty()) throw new NotFoundException();
        unitToAddTask.get().getTasks().add(taskMapper.dtoToEntity(task));
        unitRepository.save(unitToAddTask.get());
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
