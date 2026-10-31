
import java.util.Scanner;

public class Main {

    // Generic method to swap two array elements
    static <T> void swap(T[] array, int pos1, int pos2) {

        T temp = array[pos1];

        array[pos1] = array[pos2];

        array[pos2] = temp;
    }

    // Display array
    static <T> void display(T[] array) {

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Integer array
        Integer[] arr = {10, 20, 30, 40, 50};

        System.out.println("Original Array:");
        display(arr);

        System.out.print("Enter first position (0-4): ");
        int p1 = sc.nextInt();

        System.out.print("Enter second position (0-4): ");
        int p2 = sc.nextInt();

        if (p1 >= 0 && p1 < arr.length &&
            p2 >= 0 && p2 < arr.length) {

            swap(arr, p1, p2);

            System.out.println("Array after swapping:");
            display(arr);

        } else {
            System.out.println("Invalid positions!");
        }

        sc.close();
    }
}
