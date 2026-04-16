package hust.soict.dsai.aims;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;
public class Aims {
    public static void main(String[] args) {
        Cart anOrder = new Cart();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 18.99);
        anOrder.addDVD(dvd1);
        anOrder.addDVD(dvd2);
        anOrder.addDVD(dvd3);
        System.out.println("Total Cost is: " + anOrder.totalCost());

        if (anOrder.removeDVD(dvd2)) {// Remove DVD and print total cost after removal
            System.out.println("Total Cost after removal: " + anOrder.totalCost());
        }
    }
}    
