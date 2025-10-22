package BestGymEver.GymTest;

import BestGymEver.Member;
import BestGymEver.MemberFileReader;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class MemberFileReaderTest {

    // Testar MemberFileReader och att .txt läses korrekt och skapar member objekt/att varje rad delas upp rätt
    // Kollar alla fält namn, personnumer, datum och nivå -> parsas korrekt

    @Test
    public void testReadMembers() {
        MemberFileReader reader = new MemberFileReader();
        List<Member> list = reader.readMembersFromFile("GymTest/gym_medlemmar.txt");
        assertTrue(list.size() > 0);
    }
}
