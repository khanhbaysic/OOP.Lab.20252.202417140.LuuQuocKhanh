public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private int qtyOrdered = 0;
    private DVD itemsOrdered[] = new DVD[MAX_NUMBERS_ORDERED];
    public boolean addDVD(DVD dvd) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = dvd;
            qtyOrdered++;
            return true; 
        } else {
            return false;
        }
    }
    public boolean removeDVD(DVD dvd) { // Remove DVD and shift remaining DVDs to the left
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
}