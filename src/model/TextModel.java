/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.*;
import java.util.*;

public class TextModel {
    private List<String> lines;

    public TextModel() {
        lines = new ArrayList<>();
    }

    public void readInputFile(String inputFilePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
        String line;
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
        reader.close();
    }

public List<String> processLines() {
    List<String> processedLines = new ArrayList<>();
    boolean isFirstLine = true;
    boolean newParagraph = false;

    for (String line : lines) {
        if (!line.trim().isEmpty()) {
            String processedLine = processLine(line);

            if (newParagraph) {
                processedLine = " " + processedLine;
            }

            if (!processedLine.isEmpty() || isFirstLine) {
                if (isFirstLine) {
                    processedLine = processedLine.substring(0, 1).toUpperCase() + processedLine.substring(1);
                    isFirstLine = false;
                }
                processedLines.add(processedLine);
                newParagraph = false;
            }
        } else {
            newParagraph = true;
        }
    }

    // Thêm dấu chấm vào cuối văn bản
    processedLines.add(".");
    return processedLines;
}

    private String processLine(String line) {
        line = line.replaceAll("\\s+", " ");
        line = line.replaceAll("([,.:])\\s+", "$1 ");
        line = line.replaceAll("\\.\\s+(\\p{Lower})", ". $1");
        line = line.replaceAll("\"\\s+", "\"").replaceAll("\\s+\"", "\"");
        line = line.replaceAll("\\s+([,.])", "$1");

        return line;
    }
}


