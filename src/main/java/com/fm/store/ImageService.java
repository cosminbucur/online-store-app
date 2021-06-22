package com.fm.store;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ImageService {

    public byte[] loadImage(String source) {
        Path path = Paths.get(source);
        try {
            return Files.readAllBytes(path);
        } catch (IOException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }

    public byte[] loadImage2(String source) {
        try {
            return getFileFromResourceAsStream(source).readAllBytes();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private InputStream getFileFromResourceAsStream(String fileName) {
        // The class loader that loaded the class
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);

        // the stream holding the file content
        if (inputStream == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return inputStream;
        }
    }
}
