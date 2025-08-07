package com.plagiarismchecker;

import com.plagiarismchecker.model.ComparisonResult;

import java.io.IOException;
import java.util.List; // Correct this line

public class Main {
    public static void main(String[] args) {
        // The path to the directory containing the code files to check.
        // The "." means the root directory of the project.
        String directoryToCheck = "sample_code";

        PlagiarismChecker checker = new PlagiarismChecker();
        try {
            List<ComparisonResult> results = checker.checkPlagiarism(directoryToCheck);

            System.out.println("Plagiarism Check Results:");
            System.out.println("=========================");

            if (results.isEmpty()) {
                System.out.println("No pairs of files to compare.");
            } else {
                for (ComparisonResult result : results) {
                    System.out.printf("Files: %s and %s%n", result.file1(), result.file2());
                    System.out.printf("Similarity: %.2f%%%n%n", result.similarityScore() * 100);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading files: " + e.getMessage());
        }
    }
}