
import java.util.Scanner;

class Stack {
    int[] stack = new int[5];
    int top = -1;

    // Push operation
    void push(int value) {
        if (isFull()) {
            System.out.println("Stack Overflow!");
        } else {
            top++;
            stack[top] = value;
            System.out.println(value + " inserted into stack.");
        }
    }

    // Pop operation
    void pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow!");
        } else {
            System.out.println("Deleted element: " + stack[top]);
            top--;
        }
    }

    // Check whether stack is empty
    boolean isEmpty() {
        return top == -1;
    }

    // Check whether stack is full
    boolean isFull() {
        return top == stack.length - 1;
    }

    // Display stack elements
    void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
        } else {
            System.out.println("Stack elements:");

            for (int i = top; i >= 0; i--) {
                System.out.println(stack[i]);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Stack s = new Stack();

        int choice;

        do {
            System.out.println("\n--- STACK OPERATIONS ---");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Check isEmpty");
            System.out.println("4. Check isFull");
            System.out.println("5. Display");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter element: ");
                    int value = sc.nextInt();
                    s.push(value);
                    break;

                case 2:
                    s.pop();
                    break;

                case 3:
                    if (s.isEmpty())
                        System.out.println("Stack is empty.");
                    else
                        System.out.println("Stack is not empty.");
                    break;

                case 4:
                    if (s.isFull())
                        System.out.println("Stack is full.");
                    else
                        System.out.println("Stack is not full.");
                    break;

                case 5:
                    s.display();
                    break;

                case 0:
                    System.out.println("Program terminated.");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 0);

        sc.close();
    }
}
