import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.io.*;
import java.util.Scanner;
class usecase{
    public static void main(String[] args) {
        // Create a file and store its creation date as the sent date
        File file = new File("Inputcheking");
        Calendar sentDate = Calendar.getInstance();
        sentDate.setTimeInMillis(file.lastModified());


        // Store the file name and sent date in a map
        Map<String, Calendar> files = new HashMap<>();
        files.put(file.getName(), sentDate);
        // Read the expiry days from the user
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter expiry days: ");
        int expiryDays = scan.nextInt();


        // Check the availability of the file
        Calendar currentDate = Calendar.getInstance();
        for (Map.Entry<String, Calendar> entry : files.entrySet()) {
            Calendar sent = entry.getValue();
            long diff = currentDate.getTimeInMillis() - sent.getTimeInMillis();
            long diffDays = diff / (24 * 60 * 60 * 1000);
            if (diffDays < expiryDays) {
                System.out.println("File " + entry.getKey() + " is available to download.");
            } else {
                System.out.println("File " + entry.getKey() + " is expired.We can not download");
            }
        }
    }
}
