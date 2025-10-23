package BestGymEver.GymTest;

import BestGymEver.Member;
import BestGymEver.MemberVerifier;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MemberVerifierTest {

    // Variablerna används för att testa olika fall/kategorier -> Nuvarande, föredetta eller obehörig
    // Deterministiska och kontrollerade -> Kollar att logiken i checkMemberStatus() alltid fungerar

    @Test
    public void testFindMemberByName() {
        MemberVerifier verifier = new MemberVerifier(); // Instans av verifieringsklassen
        List<Member> list = new ArrayList<>();
        list.add(new Member("Maruf", "Adress", "mail", "1234", "2020-01-01", "2025-01-01", "Guld"));

        Member found = verifier.findMember("Maruf", list);
        assertNotNull(found);
    }

    @Test
    public void testCheckMemberStatusActive() {
        MemberVerifier verifier = new MemberVerifier(); // Instans av verifieringsklassen
        Member m = new Member("Maruf", "Adress", "mail", "1234", "2020-01-01", "2025-01-01", "Platina");

        String result = verifier.checkMemberStatus(m, LocalDate.of(2025, 10, 22));
        assertTrue(result.contains("nuvarande medlem")); // Kontrollerar att uttrycket är sant
    }

    @Test
    public void testCheckMemberStatusInactive() {
        MemberVerifier verifier = new MemberVerifier();
        Member m = new Member("Maruf", "Adress", "mail", "1234", "2020-01-01", "2022-01-01", "Platina");

        String result = verifier.checkMemberStatus(m, LocalDate.of(2025, 10, 22));
        assertTrue(result.contains("fore detta medlem")); //assert kollar om påstående är sant, automatiskt, samma resultat, inte kräver inmatning.
    }

    @Test
    public void testCheckMemberStatusUnknown() {
        MemberVerifier verifier = new MemberVerifier(); // Instans av verifieringsklassen
        String result = verifier.checkMemberStatus(null, LocalDate.of(2025, 10, 22));
        assertTrue(result.contains("inte i registret")); //
    }
}

// Alla testfall körs automatiskt via JUnit och går gröna utan manuell input.