
import java.util.Scanner;

public class MatrixOperations {

    static Scanner sc = new Scanner(System.in);

    // Read matrix
    static void readMatrix(int[][] a, int rows, int cols) {
        System.out.println("Enter matrix elements:");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                a[i][j] = sc.nextInt();
            }
        }
    }

    // Display matrix
    static void displayMatrix(int[][] a, int rows, int cols) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(a[i][j] + "\t");
            }
            System.out.println();
        }
    }

    // Addition
    static void add(int[][] a, int[][] b, int r, int c) {
        System.out.println("Addition:");

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print((a[i][j] + b[i][j]) + "\t");
            }
            System.out.println();
        }
    }

    // Subtraction
    static void subtract(int[][] a, int[][] b, int r, int c) {
        System.out.println("Subtraction:");

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print((a[i][j] - b[i][j]) + "\t");
            }
            System.out.println();
        }
    }

    // Multiplication
    static void multiply(int[][] a, int[][] b, int r1,
                         int c1, int c2) {
        System.out.println("Multiplication:");

        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                int sum = 0;

                for (int k = 0; k < c1; k++) {
                    sum += a[i][k] * b[k][j];
                }

                System.out.print(sum + "\t");
            }
            System.out.println();
        }
    }

    // Division (element-wise)
    static void divide(int[][] a, int[][] b, int r, int c) {
        System.out.println("Division:");

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {

                if (b[i][j] == 0) {
                    System.out.print("Undefined\t");
                } else {
                    double result =
                        (double) a[i][j] / b[i][j];

                    System.out.printf("%.2f\t", result);
                }
            }
            System.out.println();
        }
    }

    // Transpose
    static void transpose(int[][] a, int r, int c) {
        System.out.println("Transpose:");

        for (int j = 0; j < c; j++) {
            for (int i = 0; i < r; i++) {
                System.out.print(a[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        System.out.print("Enter rows and columns of Matrix A: ");
        int r1 = sc.nextInt();
        int c1 = sc.nextInt();

        System.out.print("Enter rows and columns of Matrix B: ");
        int r2 = sc.nextInt();
        int c2 = sc.nextInt();

        if (r1 <= 0 || c1 <= 0 || r2 <= 0 || c2 <= 0) {
            System.out.println("Invalid matrix dimensions!");
            return;
        }

        int[][] A = new int[r1][c1];
        int[][] B = new int[r2][c2];

        System.out.println("Enter Matrix A:");
        readMatrix(A, r1, c1);

        System.out.println("Enter Matrix B:");
        readMatrix(B, r2, c2);

        int choice;

        do {
            System.out.println("\n--- MATRIX OPERATIONS ---");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Transpose of Matrix A");
            System.out.println("6. Transpose of Matrix B");
            System.out.println("7. Display Matrices");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    if (r1 == r2 && c1 == c2)
                        add(A, B, r1, c1);
                    else
                        System.out.println("Addition not possible!");
                    break;

                case 2:
                    if (r1 == r2 && c1 == c2)
                        subtract(A, B, r1, c1);
                    else
                        System.out.println("Subtraction not possible!");
                    break;

                case 3:
                    if (c1 == r2)
                        multiply(A, B, r1, c1, c2);
                    else
                        System.out.println("Multiplication not possible!");
                    break;

                case 4:
                    if (r1 == r2 && c1 == c2)
                        divide(A, B, r1, c1);
                    else
                        System.out.println("Division not possible!");
                    break;

                case 5:
                    transpose(A, r1, c1);
                    break;

                case 6:
                    transpose(B, r2, c2);
                    break;

                case 7:
                    System.out.println("Matrix A:");
                    displayMatrix(A, r1, c1);

                    System.out.println("Matrix B:");
                    displayMatrix(B, r2, c2);
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
