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
        // Initize store with some media items
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
    //Displauy menu options
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
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: ");
    }
    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
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
        while (true) {
            System.out.println("\n--- STORE CONTENT ---");
            for (Media m : store.getItemsInStore()) {
                System.out.println(m.toString());
            }
            storeMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 0) break;
            handleStoreOptions(choice);
        }
    }
    private static void handleStoreOptions(int choice) {
        System.out.print("Enter the title of the media: ");
        String title = scanner.nextLine();
        Media media = null;
        for (Media m : store.getItemsInStore()) {
            if (m.isMatch(title)) {
                media = m;
                break;
            }
        }
        if (media == null) {
            System.out.println("Media not found!");
            return;
        }
        switch (choice) {
            case 1: // Details
                System.out.println(media.toString());
                while (true) {
                    mediaDetailsMenu();
                    int detailsChoice = scanner.nextInt();
                    scanner.nextLine(); // Clear buffer
                    if (detailsChoice == 0) break;
                    switch (detailsChoice) {
                        case 1: // Add to cart
                            cart.addMedia(media);
                            System.out.println("Cart size: " + cart.getItemsOrdered().size());
                            break;
                        case 2: // Play
                            if (media instanceof Playable) {
                                ((Playable) media).play();
                            } else {
                                System.out.println("This media cannot be played!");
                            }
                            break;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                }
                break;
            case 2: // Add to cart
                cart.addMedia(media);
                System.out.println("Cart size: " + cart.getItemsOrdered().size());
                break;
            case 3: // Play
                if (media instanceof Playable) {
                    ((Playable) media).play();
                } else {
                    System.out.println("This media cannot be played!");
                }
                break;
            case 4:
                viewCart();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
    public static void updateStore() {
        System.out.println("\n--- UPDATE STORE ---");
        System.out.println("1. Add a media");
        System.out.println("2. Remove a media");
        System.out.println("0. Back");
        System.out.print("Choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice == 1) {
            System.out.print("Enter title to add: ");
            String title = scanner.nextLine();
            // add a new book with default values
            store.addMedia(new Book(store.getItemsInStore().size() + 1, title, "General", 0.0f));
        } else if (choice == 2) {
            System.out.print("Enter title to remove: ");
            String title = scanner.nextLine();
            Media media = null;
            for (Media m : store.getItemsInStore()) {
                if (m.isMatch(title)) {
                    media = m;
                    break;
                }
            }
            if (media != null) {
                store.removeMedia(media);
            } else {
                System.out.println("Media not found!");
            }
        }
    }
    public static void viewCart() {
        while (true) {
            cart.print();
            cartMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 0) break;
            switch (choice) {
                case 1: // Filter
                    System.out.println("Filter by:");
                    System.out.println("1. ID");
                    System.out.println("2. Title");
                    System.out.print("Choice: ");
                    int filterChoice = scanner.nextInt();
                    scanner.nextLine(); // Clear buffer
                    if (filterChoice == 1) {
                        System.out.print("Enter ID to filter: ");
                        int id = scanner.nextInt();
                        scanner.nextLine(); // Clear buffer
                        cart.search(id);
                    } else if (filterChoice == 2) {
                        System.out.print("Enter title to filter: ");
                        cart.search(scanner.nextLine());
                    } else {
                        System.out.println("Invalid choice.");
                    }
                    break;
                case 2: // Sort
                    System.out.println("1. By Title / 2. By Cost");
                    int sortType = scanner.nextInt();
                    scanner.nextLine(); // Clear buffer
                    if (sortType == 1) {
                        cart.sortByTitle();
                    } else if (sortType == 2) {
                        cart.sortByCost();
                    } else {
                        System.out.println("Invalid choice.");
                    }
                    break;
                case 3: // Remove
                    System.out.print("Enter title to remove: ");
                    String title = scanner.nextLine();
                    // Find media in cart and remove
                    Media mediaToRemove = null;
                    for (Media m : cart.getItemsOrdered()) {
                        if (m.isMatch(title)) {
                            mediaToRemove = m;
                            break;
                        }
                    }
                    if (mediaToRemove != null) {
                        cart.removeMedia(mediaToRemove);
                    } else {
                        System.out.println("Media not found in cart!");
                    }
                    break;
                case 4: // Play
                    System.out.print("Enter title to play: ");
                    String playTitle = scanner.nextLine();
                    // Find media in cart and play if possible
                    Media mediaToPlay = null;
                    for (Media m : cart.getItemsOrdered()) {
                        if (m.isMatch(playTitle)) {
                            mediaToPlay = m;
                            break;
                        }
                    }
                    if (mediaToPlay == null) {
                        System.out.println("Media not found in cart!");
                    } else if (mediaToPlay instanceof Playable) {
                        ((Playable) mediaToPlay).play();
                    } else {
                        System.out.println("This media cannot be played!");
                    }
                    break;
                case 5: // Place order
                    System.out.println("An order has been created. The cart is now empty.");
                    cart = new Cart();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    public static void initSetup() {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "Star Wars", "Sci-Fi", "George Lucas", 124, 24.95f);
        Book book1 = new Book(3, "Java Programming", "Education", 15.0f);
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(book1);
    }
}