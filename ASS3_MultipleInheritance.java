
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.WeekFields;
import java.util.Locale;

// Base class
class Person {
    String name;
    int code;

    Person(String name, int code) {
        this.name = name;
        this.code = code;
    }
}

// Account interface
interface Account {
    void setPay(double pay);
    double getPay();
}

// Admin interface
interface Admin {
    void setExperience(int experience);
    int getExperience();
}

// Employee inherits Person and implements Account and Admin
class Employee extends Person implements Account, Admin {

    double pay;
    int experience;

    Employee(String name, int code, double pay, int experience) {
        super(name, code);
        this.pay = pay;
        this.experience = experience;
    }

    public void setPay(double pay) {
        this.pay = pay;
    }

    public double getPay() {
        return pay;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getExperience() {
        return experience;
    }

    void display() {

        System.out.println("\n--- Employee Details ---");
        System.out.println("Name: " + name);
        System.out.println("Code: " + code);
        System.out.println("Pay: " + pay);
        System.out.println("Experience: " + experience + " years");

        // Current date and time
        LocalDateTime now = LocalDateTime.now();

        System.out.println("\n--- Date and Time Details ---");

        System.out.println("Current Date and Time: " +
            now.format(DateTimeFormatter.ofPattern(
                "dd-MM-yyyy HH:mm:ss")));

        System.out.println("Current Year: " + now.getYear());

        System.out.println("Month of Year: " +
            now.getMonth());

        // Week number of year
        int week = now.get(WeekFields.ISO.weekOfWeekBasedYear());

        System.out.println("Week Number of Year: " + week);

        // Check whether today is weekend
        String weekend = (now.getDayOfWeek().getValue() >= 6)
                ? "Yes" : "No";

        System.out.println("Is Weekend: " + weekend);

        System.out.println("Day of Year: " +
            now.getDayOfYear());

        System.out.println("Day of Month: " +
            now.getDayOfMonth());

        System.out.println("Day of Week: " +
            now.getDayOfWeek());
    }
}

public class Main {
    public static void main(String[] args) {

        Employee e = new Employee(
            "Sanket", 101, 50000, 3
        );

        e.display();
    }
}
