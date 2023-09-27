/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.IOException;
import model.TextModel;
import view.TextView;


public class TextController {
    private TextModel model;
    private TextView view;

    public TextController(TextModel model, TextView view) {
        this.model = model;
        this.view = view;
    }

   



    public void processText(String inputFilePath, String outputFilePath) {
        try {
            model.readInputFile(inputFilePath);
            java.util.List<String> processedLines = model.processLines();
            view.displayProcessedLines(processedLines);
            view.saveProcessedLinesToFile(processedLines, outputFilePath);
            System.out.println("Text processing complete. Results saved to " + outputFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

