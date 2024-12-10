
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class FinalProject {
    private static ArrayList<String> soldOutItems = new ArrayList<>();
    private static String[] itemArray = new String[10];

    public static void main(String[] args) {
        initializeItems();
        menu();
    }

    private static void initializeItems() {
        soldOutItems.add("Item1");
        soldOutItems.add("Item2");
        soldOutItems.add("Item3");
        // Initialize the item array with some placeholder values
        for (int i = 0; i < itemArray.length; i++) {
            itemArray[i] = "Placeholder" + (i + 1);
        }
    }

    private static void menu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Menu:");
            System.out.println("1. View Sold Out Items");
            System.out.println("2. Add Sold Out Item");
            System.out.println("3. Access Item in Array");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = getValidInput(scanner);

            switch (choice) {
                case 1:
                    viewSoldOutItems();
                    break;
                case 2:
                    addSoldOutItem(scanner);
                    break;
                case 3:
                    accessItemInArray(scanner);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
        scanner.close();
    }

    private static void viewSoldOutItems() {
        System.out.println("Sold Out Items:");
        for (String item : soldOutItems) {
            System.out.println(item);
        }
    }

    private static void addSoldOutItem(Scanner scanner) {
        System.out.print("Enter item name to add: ");
        String itemName = scanner.next();
        soldOutItems.add(itemName);
        System.out.println("Item added successfully.");
    }

    private static void accessItemInArray(Scanner scanner) {
        System.out.print("Enter index of item to access (0-9): ");
        int index = getValidIndex(scanner);
        System.out.println("Item at index " + index + ": " + itemArray[index]);
    }

    private static int getValidInput(Scanner scanner) {
        int input = -1;
        while (true) {
            try {
                input = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear the invalid input
            }
        }
        return input;
    }

    private static int getValidIndex(Scanner scanner) {
        int index = -1;
        while (true) {
            try {
                index = scanner.nextInt();
                if (index < 0 || index >= itemArray.length) {
                    throw new IndexOutOfBoundsException();
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear the invalid input
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Index out of bounds. Please enter a valid index (0-9).");
            }
        }
        return index;
    }
}
