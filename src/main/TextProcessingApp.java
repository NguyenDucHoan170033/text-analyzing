/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;



import controller.TextController;
import model.TextModel;
import view.TextView;

public class TextProcessingApp {
    public static void main(String[] args) {
        // Đường dẫn đến file input.txt trên máy của bạn
        String inputFilePath = "C:/Users/ADMIN/OneDrive/Desktop/input.txt";
        // Đường dẫn đến file output.txt trên máy của bạn
        String outputFilePath = "C:/Users/ADMIN/OneDrive/Desktop/output.txt";

        TextModel model = new TextModel();
        TextView view = new TextView();
         TextController controller = new TextController(model, new TextView());


        controller.processText(inputFilePath, outputFilePath);
    }
}
