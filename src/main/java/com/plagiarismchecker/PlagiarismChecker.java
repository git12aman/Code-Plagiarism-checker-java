package com.plagiarismchecker;

import com.plagiarismchecker.model.ComparisonResult;
import com.plagiarismchecker.util.CodeNormalizer;
import com.plagiarismchecker.util.FileUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PlagiarismChecker {

    /**
     * Checks all .java files in a directory for plagiarism against each other.
     *
     * @param directoryPath The path to the directory containing source files.
     * @return A list of comparison results.
     */
    public List<ComparisonResult> checkPlagiarism(String directoryPath) throws IOException {
        List<Path> files = findJavaFiles(directoryPath);
        List<ComparisonResult> results = new ArrayList<>();

        // Compare every file with every other file
        for (int i = 0; i < files.size(); i++) {
            for (int j = i + 1; j < files.size(); j++) {
                Path file1 = files.get(i);
                Path file2 = files.get(j);

                String code1 = FileUtil.readFileToString(file1);
                String code2 = FileUtil.readFileToString(file2);

                String normalizedCode1 = CodeNormalizer.normalizeCode(code1);
                String normalizedCode2 = CodeNormalizer.normalizeCode(code2);

                double similarity = calculateJaccardSimilarity(normalizedCode1, normalizedCode2);

                results.add(new ComparisonResult(file1.getFileName().toString(), file2.getFileName().toString(), similarity));
            }
        }
        return results;
    }

    private List<Path> findJavaFiles(String directoryPath) throws IOException {
        try (Stream<Path> stream = Files.walk(Paths.get(directoryPath))) {
            return stream
                    .filter(file -> !Files.isDirectory(file))
                    .filter(file -> file.toString().endsWith(".java"))
                    .collect(Collectors.toList());
        }
    }

    private double calculateJaccardSimilarity(String text1, String text2) {
        Set<String> set1 = new HashSet<>(Arrays.asList(text1.split("\\s+")));
        Set<String> set2 = new HashSet<>(Arrays.asList(text2.split("\\s+")));

        Set<String> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);

        Set<String> union = new HashSet<>(set1);
        union.addAll(set2);

        if (union.isEmpty()) {
            return 0.0; // Avoid division by zero
        }

        return (double) intersection.size() / union.size();
    }
}