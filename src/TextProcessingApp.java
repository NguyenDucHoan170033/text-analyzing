/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import java.io.*;

public class TextProcessingApp {
    public static void main(String[] args) {
        // Đường dẫn đến file input.txt trên máy của bạn
        String inputFilePath = "C:/Users/ADMIN/OneDrive/Desktop/input.txt";
        // Đường dẫn đến file output.txt trên máy của bạn
        String outputFilePath = "C:/Users/ADMIN/OneDrive/Desktop/output.txt";

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFilePath), "ISO-8859-1"));

            PrintWriter writer = new PrintWriter(new FileWriter(outputFilePath));

            String line;
            boolean isFirstLine = true;

            while ((line = reader.readLine()) != null) {
                // Xử lý nội dung dòng
                String processedLine = processLine(line);

                // Bỏ qua dòng trống giữa các dòng
                if (!processedLine.isEmpty() || isFirstLine) {
                    // Viết hoa ký tự đầu tiên của dòng đầu tiên
                    if (isFirstLine) {
                        processedLine = processedLine.substring(0, 1).toUpperCase() + processedLine.substring(1);
                        isFirstLine = false;
                    }
                    writer.println(processedLine);
                    System.out.println(processedLine); // In nội dung từ file input ra màn hình
                }
            }

            // Thêm dấu chấm vào cuối văn bản
            writer.println(".");
            reader.close();
            writer.close();
            System.out.println("Text processing complete. Results saved to " + outputFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String processLine(String line) {
        // Chỉ giữ lại 1 khoảng trắng giữa các từ
        line = line.replaceAll("\\s+", " ");
        // Chỉ giữ lại 1 khoảng trắng sau dấu phẩy, chấm, hai chấm
        line = line.replaceAll("([,.:])\\s+", "$1 ");
        // Viết hoa ký tự đầu tiên của từ sau dấu chấm
        line = line.replaceAll("\\.\\s+(\\p{Lower})", ". $1");
        // Loại bỏ khoảng trắng trước và sau các cụm từ trong ngoặc kép
        line = line.replaceAll("\"\\s+", "\"").replaceAll("\\s+\"", "\"");
        // Loại bỏ khoảng trắng giữa dấu phẩy, chấm và từ phía trước
        line = line.replaceAll("\\s+([,.])", "$1");

        return line;
    }
}

