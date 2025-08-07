package com.plagiarismchecker.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Utility class for file operations.
 */
public class FileUtil {

    /**
     * Reads all content from a file into a single string.
     * @param filePath The path to the file.
     * @return The content of the file as a string.
     * @throws IOException if an I/O error occurs.
     */
    public static String readFileToString(Path filePath) throws IOException {
        return Files.readString(filePath);
    }
}