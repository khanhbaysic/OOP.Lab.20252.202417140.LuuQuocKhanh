package hust.soict.dsai.aims.store;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import java.util.ArrayList;
public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<>();
    public void addMedia(Media media) {
        if (itemsInStore.size() < Cart.MAX_NUMBERS_ORDERED) {
            itemsInStore.add(media);
            System.out.println("Added to store: " + media.getTitle());
        } else {
            System.out.println("Cannot add more items. Store is full.");
        }
    }
    public void removeMedia(Media media) {
        if (itemsInStore.remove(media)) {
            System.out.println("Removed from store: " + media.getTitle());
        } else {
            System.out.println("Item not found in store: " + media.getTitle());
        }
    }
}