package hust.soict.dsai.aims.cart;
import hust.soict.dsai.aims.media.Media;
import java.util.ArrayList;
import java.util.Collections;
public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
    public ArrayList<Media> getItemsOrdered() {
        return itemsOrdered;
    }
    public void addMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            System.out.println("Media already exists in cart: " + media.getTitle());
            return;
        }
        if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
            itemsOrdered.add(media);
            System.out.println("Added to cart: " + media.getTitle());
        } else {
            System.out.println("Cannot add more items. Cart is full.");
        }
    }
    public void removeMedia(Media media) {
        if (itemsOrdered.remove(media)) {
            System.out.println("Removed from cart: " + media.getTitle());
        } else {
            System.out.println("Item not found in cart: " + media.getTitle());
        }
    }
    public double totalCost() {
        double total = 0.0;

        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }
    public void print() {
        System.out.println("\n***********************CART***********************");
        System.out.println("Ordered Items:");
        if (itemsOrdered.isEmpty()) {
            System.out.println("The cart is empty.");
        } else {
            for (int i = 0; i < itemsOrdered.size(); i++) {
                System.out.println((i + 1) + ". " + itemsOrdered.get(i).toString());
            }
        }
        System.out.println("Total cost: " + totalCost() + " $");
        System.out.println("***************************************************");
    }
    public void search(int id) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                System.out.println("Found match by ID " + id + ": " + media.toString());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No media with ID " + id + " was found in the cart.");
        }
    }
    public void search(String title) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.isMatch(title)) {
                System.out.println("Found match by title '" + title + "': " + media.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No media with title containing '" + title + "' was found.");
        }
    }
    public void sortByTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
        System.out.println("The cart has been sorted by title ascending and cost descending.");
    }
    public void sortByCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
        System.out.println("The cart has been sorted by cost descending and title ascending.");
    }
}