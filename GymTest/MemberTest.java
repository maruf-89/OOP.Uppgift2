package BestGymEver.GymTest;

import BestGymEver.Member;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

// Testar Member klassens funktion -> isActiveMember()
// Hårdkodat datum för vi inte hämtar dagens datum automatiskt i testet, vi har fast datum direkt i koden.
// Deterministiska -> alltid ger samma resultat oavsett när testen körs. Blir förutsägbart och alltid samma
// Säkerställer att logiken inte bryts om man ändrar datumen

public class MemberTest {

    // Aktiv medlem < 1år
    @Test
    public void testActiveMember() {
        Member m = new Member("Test", "Adress", "mail", "1234", "2021-01-01", "2025-01-01", "Guld");
        assertTrue(m.isActiveMember(LocalDate.of(2025, 10, 22)));
    }
    // Inaktiv medlem > 1år

    @Test
    public void testInactiveMember() {
        Member m = new Member("Test", "Adress", "mail", "1234", "2021-01-01", "2022-01-01", "Guld");
        assertFalse(m.isActiveMember(LocalDate.of(2025, 10, 22)));
    }
}
