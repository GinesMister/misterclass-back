package com.misterclass.misterclassback.functions;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class HandleFiles {

    private final static String ROOTPAHT = "userfiles/";

    public static String uploadFile(MultipartFile file, String dirName) throws IOException {
        if (file.isEmpty()) throw new IOException("No file found");

        String dirPath = ROOTPAHT + "deliveries/" + dirName + "/";

        File uploadDirFile = new File(dirPath);
        if (!uploadDirFile.exists() && uploadDirFile.mkdirs()) {
            throw new IOException("Failed to create directory " + dirPath);
        }

        // Esto es lo que falla
        String filePath = dirPath + file.getOriginalFilename();
        File dest = new File(filePath);
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            throw new IOException("Failed to save file " + filePath, e);
        }

        return filePath;
    }
}
