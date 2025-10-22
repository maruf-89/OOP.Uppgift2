package BestGymEver;

import java.time.LocalDate;

public class GymVisit {
    private String name;
    private String personNumber;
    private LocalDate visitDate;

    // Representerar ett gymbesök för PT:n

    public GymVisit(String name, String personNumber, LocalDate visitDate) {
        this.name = name;
        this.personNumber = personNumber;
        this.visitDate = visitDate;
    }
    // Returnerar sträng i format namn;personnummer;datum
    // Information om ett enskilt besök -> separat från medlemsdata -> medlem / besök

    public String toFileFormat() {
        return name + ";" + personNumber + ";" + visitDate.toString();
    }
}
