package Assignment_03;

import java.io.*;

class FileHandler {
    private BufferedWriter writer;

    FileHandler(String filename) {
        try {
            writer = new BufferedWriter(new FileWriter(filename));
            writer.write("Hello, file handling in Java!");
            System.out.println("File opened and written.");
        } catch (IOException e) {
            System.out.println("Error opening file.");
        }
    }

    protected void finalize() {
        try {
            if (writer != null) {
                writer.close();
                System.out.println("File closed in finalize()");
            }
        } catch (IOException e) {
            System.out.println("Error closing file.");
        }
    }
}

public class Q10_File {
    public static void main(String[] args) {
        new FileHandler("test.txt");
        System.gc();
    }
}