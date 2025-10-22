package BestGymEver;

import java.time.LocalDate;
import java.util.List;

public class MemberVerifier {

    // Söker på namn eller personnummer

    public Member findMember(String input, List<Member> members) {
        for (Member m : members) {
            if (m.getName().equalsIgnoreCase(input) || m.getPersonNumber().equalsIgnoreCase(input)) {
                return m;
            }
        }
        return null;
    }
    // Returnerar korrekt kategori: nuvarande, föredetta eller obehörig
    // Håller all logik för att avgöra medlemstatus på ett ställe
    // Lätt att byta regler utan att röra Main

    public String checkMemberStatus(Member member, LocalDate today) {
        if (member == null) {
            return "Personen finns inte i registret och ar obehorig.";
        } else if (member.isActiveMember(today)) {
            return "Kunden ar en nuvarande medlem. Niva: " + member.getLevel();
        } else {
            return "Kunden ar en fore detta medlem.";
        }
    }
}
