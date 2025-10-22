package BestGymEver;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MemberFileReader {

    public List<Member> readMembersFromFile(String filePath) {
        List<Member> members = new ArrayList<>();

        // Använder BufferedReader med try-with-resources -> Hoppar över headerrad i filen
        // Skapar Member objekt för varje rad och returnerar en lista med alla medlemmar
        // Ansvarar för all filinläsning -> Om filformat ändras behöver bara denna klass ändras

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            // hoppa över header
            line = reader.readLine();
            if (line == null) return members;

            //Läser alla rader från gym_medlemmar.txt totalt 7 delar
            //Skapar Member-objekt för varje rad och sparar alla dessa objekt i en lista
            //När filen är färdigläst returnerar metoden hela listan till huvudprogrammet

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 7) { //Säkerhetskontroll = 7 -> annars hoppar programmet över raden
                    Member m = new Member( // Lägger till medlemsobjektet i listan members.
                            parts[0].trim(),
                            parts[1].trim(),
                            parts[2].trim(),
                            parts[3].trim(),
                            parts[4].trim(),
                            parts[5].trim(),
                            parts[6].trim()
                    );
                    members.add(m);
                }
            }
        } catch (IOException e) { // Om filen inte finns eller inte kan läsas
            System.out.println("Fel vid lasning av fil: " + e.getMessage());
        }

        return members;
    }
}
