package com.misterclass.misterclassback.features.subject.controller;

import com.misterclass.misterclassback.exceptions.general.NotFoundException;
import com.misterclass.misterclassback.features.subject.dto.TaskDto;
import com.misterclass.misterclassback.features.subject.dto.TheoryElementDto;
import com.misterclass.misterclassback.features.subject.dto.subject.SimplifiedSubjectDto;
import com.misterclass.misterclassback.features.subject.dto.subject.SubjectDto;
import com.misterclass.misterclassback.features.subject.dto.unit.UnitDto;
import com.misterclass.misterclassback.features.subject.service.*;
import com.misterclass.misterclassback.functions.EUploadRoots;
import com.misterclass.misterclassback.functions.HandleFiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

@RestController
public class SubjectController {

    @Autowired
    private SubjectService subjectService;
    @Autowired
    private UnitService unitService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private DeliveryService deliveryService;
    @Autowired
    private TheoryElementService theoryElementService;

    @PostMapping("/subject/createSubject")
    public ResponseEntity<SimplifiedSubjectDto> createSubject(@RequestBody SimplifiedSubjectDto newSubject) {
        return ResponseEntity.status(HttpStatus.CREATED).body(subjectService.createSubject(newSubject));
    }

    @GetMapping("/subject/getById")
    public ResponseEntity<SubjectDto> getSubjectById(@RequestParam Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(subjectService.getSubjectById(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/subject/getSubjectsByTeacherId")
    public ResponseEntity<List<SimplifiedSubjectDto>> getSubjectsByTeacherId(@RequestParam String teacherId) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(subjectService.getSubjectsByTeacherId(teacherId));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/subject/subscribeStudentToSubject")
    public boolean subscribeStudentToSubject(@RequestParam String userId, @RequestParam String subjectCode) {
        try {
            return subjectService.subscribeStudentToSubject(userId, subjectCode);
        } catch (NotFoundException e) {
            return false;
        }
    }

    @DeleteMapping("/subject/delete")
    public ResponseEntity<Boolean> deleteSubject(@RequestParam long id) {
        if (!subjectService.deleteSubjectById(id))
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        else return ResponseEntity.status(HttpStatus.OK).build();
    }

    // UPDATE OF SUBJECT
    // UNIT
    @PutMapping("subject/unit/create")
    public ResponseEntity<Void> createUnit(@RequestParam long subjectId, @RequestBody UnitDto unit) {
        try {
            unitService.createUnit(subjectId, unit);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("subject/unit/update")
    public ResponseEntity<Void> updateUnit(@RequestParam long unitId, @RequestBody UnitDto unit) {
        try {
            unitService.updateUnit(unitId, unit);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("subject/unit/delete")
    public ResponseEntity<Void> deleteUnit(@RequestParam long unitId) {
        try {
            unitService.deleteUnit(unitId);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // TASK
    @PutMapping("subject/task/create")
    public ResponseEntity<Void> createTask(@RequestParam long unitId, @RequestPart TaskDto task, @RequestPart MultipartFile file) {
        try {
            taskService.createTask(unitId, task, file);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping("subject/task/update")
    public ResponseEntity<Void> updateTask(@RequestParam long taskId, @RequestBody TaskDto task) {
        try {
            taskService.updateTask(taskId, task);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("subject/task/delete")
    public ResponseEntity<Void> deleteTask(@RequestParam long taskId) {
        try {
            taskService.deleteTask(taskId);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/subject/task/files/{taskId}/{filename:.+}")
    public ResponseEntity<Resource> downloadTaskFileByPath(@PathVariable long taskId, @PathVariable String filename) {
        try {
            Resource resource = HandleFiles.getFileByName(filename, taskId, EUploadRoots.TASK_PATH);
            String contentType = "application/octet-stream";
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"");
            return ResponseEntity.ok()
                    .headers(headers)
                    .contentLength(resource.contentLength())
                    .contentType(MediaType.parseMediaType(contentType))
                    .body(resource);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // DELIVER
    @PutMapping("subject/delivery/create")
    public ResponseEntity<Void> createDelivery(@RequestParam long taskId, @RequestParam String delivererId, @RequestParam MultipartFile file) throws IOException {
        try {
            deliveryService.createDelivery(taskId, delivererId, file);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping("subject/delivery/mark")
    public ResponseEntity<Void> markDelivery(@RequestParam long deliveryId, @RequestParam double mark) {
        try {
            deliveryService.markDelivery(deliveryId, mark);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/subject/delivery/files/{deliveryId}/{filename:.+}")
    public ResponseEntity<Resource> downloadDeliveryFileByPath(@PathVariable long deliveryId, @PathVariable String filename) {
        try {
            Resource resource = HandleFiles.getFileByName(filename, deliveryId, EUploadRoots.DELIVERY_PATH);
            String contentType = "application/octet-stream";
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"");
            return ResponseEntity.ok()
                    .headers(headers)
                    .contentLength(resource.contentLength())
                    .contentType(MediaType.parseMediaType(contentType))
                    .body(resource);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // THEORY ELEMENT
    @PutMapping("subject/theoryelement/create")
    public ResponseEntity<Void> createTheoryElement(@RequestParam long unitId, @RequestPart MultipartFile file, @RequestPart TheoryElementDto theoryElement) {
        try {
            theoryElementService.createTheoryElement(unitId, theoryElement, file);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/subject/theoryElement/files/{theoryElementId}/{filename:.+}")
    public ResponseEntity<Resource> downloadTheoryElementFileByPath(@PathVariable long theoryElementId, @PathVariable String filename) {
        try {
            Resource resource = HandleFiles.getFileByName(filename, theoryElementId, EUploadRoots.THEORY_PATH);
            String contentType = "application/octet-stream";
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"");
            return ResponseEntity.ok()
                    .headers(headers)
                    .contentLength(resource.contentLength())
                    .contentType(MediaType.parseMediaType(contentType))
                    .body(resource);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
