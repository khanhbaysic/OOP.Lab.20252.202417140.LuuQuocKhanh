package hust.soict.dsai.aims;

import java.util.Scanner;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.media.*;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initSetup();
        int choice;
        while (true) {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1:
                    viewStore();
                    break;
                case 2:
                    updateStore();
                    break;
                case 3:
                    viewCart();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: ");
    }
    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: ");
    }
    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: ");
    }
    public static void viewStore() {
        // print all media in store
        for (Media m : store.getItemsInStore()) {
            System.out.println(m.toString());
        }
        while (true) {
            storeMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 0) break;
            // Process See Details, Add to Cart, Play...
        }
    }
    public static void viewCart() {
        cart.print();
        while (true) {
            cartMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 0) break;
            if (choice == 2) { // Sort
                System.out.println("1. Sort by title / 2. Sort by cost");
                int sortChoice = scanner.nextInt();
                if (sortChoice == 1) cart.sortByTitle();
                else cart.sortByCost();
                cart.print();
            }
            if (choice == 5) {
                System.out.println("An order has been created. The cart is now empty.");
                cart = new Cart(); // Reset cart
            }
        }
    }
    public static void initSetup() {
        DigitalVideoDisc dvd = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        Book book = new Book(1, "Java Programming", "Education", 25.5f);
        book.addAuthor("Huy Tran");
        store.addMedia(dvd);
        store.addMedia(book);
    }
}