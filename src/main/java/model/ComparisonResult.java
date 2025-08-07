package com.plagiarismchecker.model;

/**
 * A record to hold the result of a single file comparison.
 *
 * @param file1 The path of the first file.
 * @param file2 The path of the second file.
 * @param similarityScore The calculated similarity score (0.0 to 1.0).
 */
public record ComparisonResult(String file1, String file2, double similarityScore) {
}