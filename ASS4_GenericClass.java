
import java.util.ArrayList;

class GenericStack<T> {

    ArrayList<T> stack = new ArrayList<>();

    // Push operation
    void push(T item) {
        stack.add(item);
        System.out.println(item + " inserted.");
    }

    // Pop operation
    T pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return null;
        }

        return stack.remove(stack.size() - 1);
    }

    // Peek operation
    T peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return null;
        }

        return stack.get(stack.size() - 1);
    }

    // Check whether stack is empty
    boolean isEmpty() {
        return stack.isEmpty();
    }

    // Display stack
    void display() {
        System.out.println("Stack: " + stack);
    }
}

public class Main {
    public static void main(String[] args) {

        // Integer stack
        GenericStack<Integer> s1 = new GenericStack<>();

        s1.push(10);
        s1.push(20);
        s1.push(30);

        s1.display();

        System.out.println("Top element: " + s1.peek());
        System.out.println("Removed element: " + s1.pop());

        s1.display();

        // String stack
        GenericStack<String> s2 = new GenericStack<>();

        s2.push("Java");
        s2.push("Python");
        s2.push("C++");

        s2.display();

        System.out.println("Top element: " + s2.peek());
        System.out.println("Removed element: " + s2.pop());

        s2.display();
    }
}
