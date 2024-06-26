package com.misterclass.misterclassback.functions;

import com.misterclass.misterclassback.exceptions.general.NotFoundException;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.FileUrlResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class HandleFiles {

    private final static String ROOT_PATH = "userfiles/";
    private final static String DELIVERY_PATH = ROOT_PATH + "deliveries/";
    private final static String THEORY_PATH = ROOT_PATH + "theory/";
    private final static String TASK_PATH = ROOT_PATH + "task/";

    public static String uploadFile(MultipartFile file, String dirName, EUploadRoots path) throws IOException {
        if (file.isEmpty()) throw new IOException("No file found");

        String uploadDir;
        switch (path) {
            case DELIVERY_PATH -> uploadDir = DELIVERY_PATH;
            case THEORY_PATH -> uploadDir = THEORY_PATH;
            case TASK_PATH -> uploadDir = TASK_PATH;
            default -> uploadDir = ROOT_PATH;
        }

        uploadDir += dirName;

        Path uploadPath = Paths.get(uploadDir);

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        Path filePath = uploadPath.resolve(file.getOriginalFilename());
        System.out.println(file.getOriginalFilename());
        Files.copy(file.getInputStream(), filePath);

        // Returns the name
        return file.getOriginalFilename();
    }

    public static Resource getFileByName(String filename, long id, EUploadRoots path) throws MalformedURLException, NotFoundException {
        String fileDir;
        switch (path) {
            case DELIVERY_PATH -> fileDir = DELIVERY_PATH;
            case THEORY_PATH -> fileDir = THEORY_PATH;
            case TASK_PATH -> fileDir = TASK_PATH;
            default -> fileDir = ROOT_PATH;
        }
        fileDir += id;
        Path downloadPath = Paths.get(fileDir);
        Path file = downloadPath.resolve(filename);
        Resource resource = new UrlResource(file.toUri());
        return resource;
    }
}

