import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.*;
public class Usecase1 {
    public static void main(String[] args)  {
        try{
            // Create a HashMap to store the file extensions and their frequencies
            Map<String, Integer> extensionFrequency = new HashMap<>();
            // Assume that these are the files in the current directory
            System.out.println("Enter the directory path:");
            Scanner scan = new Scanner(System.in);
            String directoryPath = scan.nextLine();
            File directory = new File(directoryPath);
            File[] files = directory.listFiles();
            // Iterate through the files and count the frequency of each file extension
            for (File file : files) {
                String fileName = file.getName();
                int index = fileName.lastIndexOf('.');
                if (index > 0) {
                    String extension = fileName.substring(index + 1);
                    if (extensionFrequency.containsKey(extension)) {
                        extensionFrequency.put(extension, extensionFrequency.get(extension) + 1);
                    } else {
                        extensionFrequency.put(extension, 1);
                    }
                }
            }
            // Print the frequency of each file extension
            for (Map.Entry<String, Integer> entry : extensionFrequency.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
            // Print the total number of files
            System.out.println("Total number of files: " + files.length);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

}
