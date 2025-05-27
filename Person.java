package program3;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

// Person class
class Person1 {
    protected String name;
    protected LocalDate dob;

    public Person1(String name, String dobString) {
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

// Employee class extends Person
class Employee extends Person1 {
    private int empId;
    private double salary;

    public Employee(String name, String dob, int empId, double salary) {
        super(name, dob);
        this.empId = empId;
        this.salary = salary;
    }

    public void displayEmployeeDetails() {
        displayName();
        displayAge();
        System.out.println("Employee ID: " + empId);
        System.out.println("Salary: ₹" + salary);
    }
}

// Main class
public class Person {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Date of Birth (DD-MM-YYYY or YYYY-MM-DD): ");
        String dob = sc.nextLine();

        System.out.print("Enter Employee ID: ");
        int empId = sc.nextInt();

        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();

        Employee emp = new Employee(name, dob, empId, salary);

        System.out.println("\n--- Employee Details ---");
        emp.displayEmployeeDetails();

        sc.close();
    }
}
