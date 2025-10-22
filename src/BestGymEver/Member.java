package BestGymEver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Member {
    private String name;
    private String address;
    private String email;
    private String personNumber;
    private LocalDate startDate;
    private LocalDate lastPaidDate;
    private String level;

    public Member(String name, String address, String email, String personNumber, String startDate, String lastPaidDate, String level) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.name = name;
        this.address = address;
        this.email = email;
        this.personNumber = personNumber;
        this.startDate = LocalDate.parse(startDate.trim(), formatter);
        this.lastPaidDate = LocalDate.parse(lastPaidDate.trim(), formatter);
        this.level = level;
    }

    public String getName() { return name; }
    public String getPersonNumber() { return personNumber; }
    public LocalDate getLastPaidDate() { return lastPaidDate; }
    public String getLevel() { return level; }

    // Kollar om medlemsavgiften är mindre än ett år gammal
    // Lagrar all info som behövs för att avgöra kategori(nuvarande/föredetta medlem samt guld/platina/standard)

    public boolean isActiveMember(LocalDate today) {
        return lastPaidDate.isAfter(today.minusYears(1)) || lastPaidDate.isEqual(today.minusYears(1));
    }
}
