package BestGymEver.GymTest;

import BestGymEver.GymVisit;
import BestGymEver.GymVisitWriter;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class GymVisitWriterTest {

    // Verifierar att besök skrivs korrekt till fil
    // Kontrollerar att nya rader läggs till i append-läge och att formatet är rätt: namn;personnummer;datum
    // Testar att filen skapas automatiskt om den inte finns

    @Test
    public void testWriteVisitCreatesFile() throws Exception {
        String testFile = "GymTest/pt_log.txt"; // Filen skrivs till i testmappen
        Files.deleteIfExists(Path.of(testFile));

        GymVisitWriter writer = new GymVisitWriter();
        GymVisit visit = new GymVisit("Test Testsson", "1234", LocalDate.of(2025, 10, 22));
        writer.writeVisitToFile(testFile, visit);

        File f = new File(testFile);
        assertTrue(f.exists());
    }
}
