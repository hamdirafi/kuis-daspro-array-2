import java.util.Scanner;

public class LibraryStock01 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Define book subjects and stock types
        String[] subjects = {"Database", "Mathematics", "Algorithm"};
        String[] stockTypes = {"In Stock", "Damaged Stock", "Out of Stock"};

        // 2D array to store stock values
        int[][] stock = new int[3][3];

        // Input stock data
        System.out.println("Enter library stock data:");
        for (int i = 0; i < subjects.length; i++) {
            System.out.println("Subject: " + subjects[i]);
            for (int j = 0; j < stockTypes.length; j++) {
                while (true) { // Validate input
                    System.out.print(stockTypes[j] + ": ");
                    if (input.hasNextInt()) { // Ensure the input is a number
                        stock[i][j] = input.nextInt();
                        if (stock[i][j] >= 0) { // Stock values must be positive or zero
                            break;
                        } else {
                            System.out.println("Please enter a valid value (>= 0).");
                        }
                    } else {
                        System.out.println("Please enter a valid number!");
                        input.next(); // Clear invalid input
                    }
                }
            }
            System.out.println();
        }

        // Display the stock table
        System.out.printf("%-12s %-12s %-15s %-15s%n", "Subject", "In Stock", "Damaged Stock", "Out of Stock");
        for (int i = 0; i < subjects.length; i++) {
            System.out.printf("%-12s", subjects[i]);
            for (int j = 0; j < stockTypes.length; j++) {
                System.out.printf("%-15d", stock[i][j]);
            }
            System.out.println();
        }

        // Calculate the total number of books available to borrow (In Stock)
        int totalInStock = 0;
        for (int i = 0; i < stock.length; i++) {
            totalInStock += stock[i][0]; // "In Stock" column is at index 0
        }
        System.out.println("\nTotal books available to borrow: " + totalInStock);

        // Find the book with the largest stock
        int maxInStock = stock[0][0];
        String bookWithMaxStock = subjects[0];

        for (int i = 1; i < stock.length; i++) {
            if (stock[i][0] > maxInStock) {
                maxInStock = stock[i][0];
                bookWithMaxStock = subjects[i];
            }
        }

        System.out.println("The book with the largest stock available to borrow is: " + bookWithMaxStock + " (" + maxInStock + " books)");

        // Find the book(s) with the smallest stock
        int minInStock = stock[0][0];
        for (int i = 1; i < stock.length; i++) {
            if (stock[i][0] < minInStock) {
                minInStock = stock[i][0];
            }
        }

        System.out.print("The book(s) with the smallest stock available to borrow: ");
        for (int i = 0; i < stock.length; i++) {
            if (stock[i][0] == minInStock) {
                System.out.print(subjects[i] + " ");
            }
        }
        System.out.println("(" + minInStock + " books)");

        input.close();
    }
}
