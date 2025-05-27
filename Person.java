package program3;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Person {
    protected String name;
    protected LocalDate dob;

    public Person(String name, String dobString) {
        this.name = name;
        this.dob = parseDate(dobString);
    }

    private LocalDate parseDate(String dobString) {
        DateTimeFormatter formatter;
        if (dobString.matches("\\d{2}-\\d{2}-\\d{4}")) {
            formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        } else if (dobString.matches("\\d{4}-\\d{2}-\\d{2}")) {
            formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        } else {
            throw new IllegalArgumentException("Invalid date format. Use DD-MM-YYYY or YYYY-MM-DD.");
        }
        return LocalDate.parse(dobString, formatter);
    }

    public void displayName() {
        System.out.println("Name: " + name);
    }

    public void displayAge() {
        int age = Period.between(dob, LocalDate.now()).getYears();
        System.out.println("Age: " + age + " years");
    }
}
