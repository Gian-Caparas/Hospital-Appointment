package utils;

import models.Appointment;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
public class FileManager {

    public static void saveAppointmentToFile(Appointment appointment) {
        try {
            // Create records/ directory if it doesn't exist
            Files.createDirectories(Paths.get("records"));

            String fileName = "records/" + LocalDate.now() + "_appointment.txt";

            // Append mode — supports multiple appointments per day in the same file
            PrintWriter writer = new PrintWriter(new FileWriter(fileName, true));
            writer.println(appointment.toFileString());
            writer.close();

            System.out.println("\n  Saving record...");
            System.out.println("  File saved to: " + fileName);

        } catch (IOException e) {
            System.out.println("  [ERROR] Could not save file: " + e.getMessage());
        }
    }
}