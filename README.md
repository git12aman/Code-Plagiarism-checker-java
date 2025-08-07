## Code Plagiarism Checker (Command-Line Tool) 📄

A powerful and efficient command-line tool built in Java to detect similarity between source code files. This application is designed for developers, educators, and anyone needing to perform automated code analysis. It analyzes all .java files within a directory, calculates a similarity score based on their content, and prints a report to the console. The tool intelligently ignores stylistic differences like comments and whitespace to provide a more accurate measure of logical similarity.

## Output Example
When run on a sample directory, the tool produces a clean and easy-to-read report directly in your terminal:

## Bash

$ mvn exec:java

Checking for plagiarism in directory: sample_code
======================================================
Comparison: Plagiarized.java <-> Different.java
Similarity Score: 25.00%

Comparison: Plagiarized.java <-> Original.java
Similarity Score: 84.62%

Comparison: Different.java <-> Original.java
Similarity Score: 25.00%
## Features
⚡ Fast Command-Line Interface (CLI): Lightweight and ideal for scripting, automation, and integration with other development workflows.

📁 Flexible Input: Accepts a directory path as a command-line argument. If no path is provided, it defaults to checking a local sample_code directory.

🧹 Smart Code Normalization: Before comparison, the tool automatically removes comments, string literals, and standardizes whitespace to ensure the analysis is based on the code's substance, not its style.

🧮 Jaccard Index Algorithm: Employs the Jaccard Index to accurately calculate a similarity score by measuring the overlap between the sets of words (tokens) in the code files.

📄 Standard Console Output: Prints results directly to the standard output, making it easy to pipe the report to a file or other programs.

⚙️ Efficient Comparison: Intelligently compares only unique pairs of files, avoiding redundant checks.

## How It Works
The application's logic is broken down into a simple, sequential process:

Initialization: The main method starts the application. It checks for a command-line argument to use as the target directory path.

File Discovery: The PlagiarismChecker scans the target directory and compiles a list of all files ending with the .java extension.

Code Normalization: For each file being compared, its source code is read and passed through the CodeNormalizer. This utility strips out all comments and collapses all tabs, newlines, and spaces into a single space, creating a "sanitized" version of the code.

Tokenization & Set Creation: The normalized string of code is then tokenized (split into words), and these tokens are stored in a HashSet to get a unique collection of the words used in the code.

Similarity Calculation: For every unique pair of files, the Jaccard Index is calculated on their corresponding token sets. The formula is:

J(A,B)= 
∣A∪B∣
∣A∩B∣
​
 

This yields a score between 0.0 (no similarity) and 1.0 (identical content).

Reporting: The results, including the names of the two files and their calculated similarity score, are printed to the console in a formatted, human-readable report.

## Technologies Used
Core Language: Java (Built on JDK 17)

Build & Dependency Management: Apache Maven

Execution Plugin: Exec Maven Plugin to easily run the application from the command line.

## Getting Started
Follow these instructions to get a copy of the project up and running on your local machine.

### Prerequisites
Make sure you have the following software installed:

Java Development Kit (JDK) - Version 17 or newer.

Apache Maven - To build the project and manage dependencies.

Git - To clone the repository.

### How to Run
Clone the repository to your local machine:

Bash

git clone https://github.com/your-username/plagiarism-checker-cli.git
cd plagiarism-checker-cli
Run the application using Maven:
Open your terminal in the project's root directory and execute the following command:

Bash

# This will check the default 'sample_code' directory
mvn clean compile exec:java
(Optional) Run with a custom directory path:
You can specify a different directory by passing an argument to the exec plugin:

Bash

# Replace 'path/to/your/code' with the actual path
mvn exec:java -Dexec.args="path/to/your/code"
## Project Structure
The project follows a simple and clean command-line application structure.

plagiarism-checker-cli/
├── pom.xml                   # Maven Project Configuration
└── src/
    └── main/
        └── java/
            └── com/
                └── plagiarismchecker/
                    ├── model/
                    │   └── ComparisonResult.java # Data model for results
                    ├── util/
                    │   ├── CodeNormalizer.java # Cleans the source code
                    │   └── FileUtil.java       # Reads files
                    ├── Main.java               # Main Application entry point
                    └── PlagiarismChecker.java  # Core plagiarism logic
## Future Improvements
Build a GUI: Develop a graphical user interface using JavaFX to make the tool more accessible to non-technical users.

Advanced Algorithms: Implement more sophisticated comparison algorithms like Levenshtein Distance or AST (Abstract Syntax Tree) parsing.

Broader Language Support: Add configurations and parsers to handle other programming languages like Python, C++, or JavaScript.

Export Results: Add a feature to save the output report to a file (e.g., .txt, .csv, .json).

## License
This project is licensed under the MIT License - see the LICENSE file for details.
