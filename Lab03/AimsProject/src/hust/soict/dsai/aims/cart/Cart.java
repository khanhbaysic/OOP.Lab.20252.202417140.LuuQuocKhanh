package hust.soict.dsai.aims.cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;
public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private int qtyOrdered = 0;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    public boolean addDVD(DigitalVideoDisc dvd) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = dvd;
            qtyOrdered++;
            return true; 
        } else {
            return false;
        }
    }
    public boolean removeDVD(DigitalVideoDisc dvd) { // Remove DVD and shift remaining DVDs to the left
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].equals(dvd)) {
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                itemsOrdered[qtyOrdered - 1] = null;
                qtyOrdered--;
                return true; 
            }
        }
        return false; 
    }
    public double totalCost() {
        double total = 0.0;
        for (int i = 0; i < qtyOrdered; i++) {
            total += itemsOrdered[i].getCost();
        }
        return total;
    }
public boolean addDigitalVideoDisc(DigitalVideoDisc disc) {
    if (qtyOrdered < MAX_NUMBERS_ORDERED) {
        itemsOrdered[qtyOrdered] = disc;
        qtyOrdered++;
        return true;
    } else {
        return false;
    }
}
public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
    for (DigitalVideoDisc dvd : dvdList) {
        if (addDVD(dvd)) {
            System.out.println("Added: " + dvd.getTitle());
        } else {
            System.out.println("The cart is full. Could not add: " + dvd.getTitle());
            break;
        }
    }
}
public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
    if (addDigitalVideoDisc(dvd1)) {
        System.out.println("Added: " + dvd1.getTitle());
    } else {
        System.out.println("The cart is full. Could not add: " + dvd1.getTitle());
        return;
    }
    if (addDigitalVideoDisc(dvd2)) {
        System.out.println("Added: " + dvd2.getTitle());
    } else {
        System.out.println("The cart is full. Could not add: " + dvd2.getTitle());
    }
}
public void print() {
    System.out.println("***********************CART***********************");
    System.out.println("Ordered Items:");
    for (int i = 0; i < qtyOrdered; i++) {
        System.out.println((i + 1) + ". " + itemsOrdered[i].toString());
    }
    System.out.println("Total cost: " + totalCost() + " $");
    System.out.println("***************************************************");
}

public void search(int id) {
    boolean found = false;
    for (int i = 0; i < qtyOrdered; i++) {
        if (itemsOrdered[i].getId() == id) {
            System.out.println("Found match by ID " + id + ": " + itemsOrdered[i].toString());
            found = true;
            break;
        }
    }
    if (!found) {
        System.out.println("No DVD with ID: " + id + " was found in the cart.");
    }
}
public void search(String title) {
    boolean found = false;
    for (int i = 0; i < qtyOrdered; i++) {
        if (itemsOrdered[i].isMatch(title)) {
            System.out.println("Found match by Title '" + title + "': " + itemsOrdered[i].toString());
            found = true;
        }
    }
    if (!found) {
        System.out.println("No DVD with title containing '" + title + "' was found.");
    }
}
}
