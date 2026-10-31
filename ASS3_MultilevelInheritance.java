
import java.util.Scanner;

// Base class
class Shape {

    void displayShape() {
        System.out.println("This is a Shape.");
    }
}

// Derived class
class TwoDShape extends Shape {

    double length;
    double breadth;

    void setDimensions(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    void displayDimensions() {
        System.out.println("Length: " + length);
        System.out.println("Breadth: " + breadth);
    }
}

// Derived class of TwoDShape
class Triangle extends TwoDShape {

    double calculateArea() {
        return 0.5 * length * breadth;
    }

    void displayArea() {
        System.out.println("Area of Triangle: " +
                           calculateArea());
    }
}

// Main class
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Triangle t = new Triangle();

        System.out.print("Enter base of triangle: ");
        double base = sc.nextDouble();

        System.out.print("Enter height of triangle: ");
        double height = sc.nextDouble();

        // Inherited method from Shape
        t.displayShape();

        // Method of TwoDShape
        t.setDimensions(base, height);
        t.displayDimensions();

        // Method of Triangle
        t.displayArea();

        sc.close();
    }
}
