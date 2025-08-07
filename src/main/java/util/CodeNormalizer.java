package com.plagiarismchecker.util;

/**
 * Normalizes source code by removing comments and standardizing whitespace.
 */
public class CodeNormalizer {

    /**
     * Normalizes a given string of source code.
     * @param code The source code to normalize.
     * @return The normalized code string.
     */
    public static String normalizeCode(String code) {
        // 1. Remove all block comments (/* ... */)
        String noBlockComments = code.replaceAll("/\\*[\\s\\S]*?\\*/", "");

        // 2. Remove all line comments (// ...)
        String noLineComments = noBlockComments.replaceAll("//.*", "");

        // 3. Remove all string literals ("...") to avoid matching on them
        String noStringLiterals = noLineComments.replaceAll("\"(.*?)\"", "");

        // 4. Replace all sequences of whitespace with a single space and trim
        String singleSpaced = noStringLiterals.replaceAll("\\s+", " ").trim();

        return singleSpaced;
    }
}