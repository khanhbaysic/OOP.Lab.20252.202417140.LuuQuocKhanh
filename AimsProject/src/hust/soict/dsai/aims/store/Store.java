package hust.soict.dsai.aims.store;
import hust.soict.dsai.aims.media.Media;
import java.util.ArrayList;
public class Store {
    public static final int MAX_ITEMS_IN_STORE = 100;
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();
    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }
    public void addMedia(Media media) {
        if (itemsInStore.contains(media)) {
            System.out.println("Media already exists in store: " + media.getTitle());
            return;
        }
        if (itemsInStore.size() < MAX_ITEMS_IN_STORE) {
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