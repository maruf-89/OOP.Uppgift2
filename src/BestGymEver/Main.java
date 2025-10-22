package BestGymEver;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Sökväg för .txt filer
        String memberFile = "src/BestGymEver/gym_medlemmar.txt";
        String ptFile = "src/BestGymEver/pt_log.txt";

        // Läser medlemsfil

        MemberFileReader reader = new MemberFileReader(); // Läser
        MemberVerifier verifier = new MemberVerifier(); // Bekräftar medlem
        GymVisitWriter writer = new GymVisitWriter(); // Registrerar

        List<Member> members = reader.readMembersFromFile(memberFile);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Skriv in kundens namn eller personnummer:");
        String input = scanner.nextLine();

        Member found = verifier.findMember(input, members);
        String status = verifier.checkMemberStatus(found, LocalDate.now());
        System.out.println(status);

        if (found != null && found.isActiveMember(LocalDate.now())) {
            GymVisit visit = new GymVisit(found.getName(), found.getPersonNumber(), LocalDate.now());
            writer.writeVisitToFile(ptFile, visit);
            System.out.println("Besok registrerat i PT-loggen.");
        } else {
            System.out.println("Ingen registrering i PT-loggen.");
        }
    }
}
