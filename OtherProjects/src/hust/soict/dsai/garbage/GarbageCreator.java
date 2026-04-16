package hust.soict.dsai.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCreator {
    public static void main(String[] args) throws IOException {
        String filename = "test.pdf"; 
        byte[] inputBytes = { 0 };
        long start, end;

        try {
            inputBytes = Files.readAllBytes(Paths.get(filename));
        } catch (IOException e) {
            System.out.println("Error: Could not find file " + filename);
            return;
        }

        start = System.currentTimeMillis();
        String outputString = "";
        for (byte b : inputBytes) {
            outputString += (char) b; 
        }
        end = System.currentTimeMillis();
        
        System.out.println("Processing time with + : " + (end - start) + "ms");
    }
}