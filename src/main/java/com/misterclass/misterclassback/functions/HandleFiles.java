package com.misterclass.misterclassback.functions;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class HandleFiles {

    private final static String ROOTPAHT = "userfiles/";

    public static String uploadFile(MultipartFile file, String dirName) throws IOException {
        if (file.isEmpty()) throw new IOException("No file found");

        String uploadDir = ROOTPAHT + "deliveries/" + dirName + "/";
        Path uploadPath = Paths.get(uploadDir);

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        Path filePath = uploadPath.resolve(file.getOriginalFilename());
        Files.copy(file.getInputStream(), filePath);

        // Returns the download URL
        return ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/" + uploadDir)
                .path(file.getOriginalFilename())
                .toUriString();
    }
}
