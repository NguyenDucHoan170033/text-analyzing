/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.io.*;
import java.util.*;

public class TextView {
  public void displayProcessedLines(List<String> processedLines) {
    for (String line : processedLines) {
        System.out.print(line);
    }
}

public void saveProcessedLinesToFile(List<String> processedLines, String outputFilePath) throws IOException {
    PrintWriter writer = new PrintWriter(new FileWriter(outputFilePath));
    for (String line : processedLines) {
        writer.print(line);
    }
    writer.close();
}
}

