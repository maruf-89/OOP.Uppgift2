package BestGymEver;

import java.io.*;
import java.nio.file.*;

public class GymVisitWriter {

    // Skapar fil om den inte finns -> Skriver i appendläge (behåller tidigare besök)
    // Använder try-with-resources för säker filhantering -> Håller filskrivning isolerad (enkelt att återanvända)

    public void writeVisitToFile(String filePath, GymVisit visit) {
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                file.createNewFile();
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
                writer.write(visit.toFileFormat());
                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("Fel vid skrivning till fil: " + e.getMessage());
        }
    }
}
