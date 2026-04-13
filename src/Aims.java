public class Aims {
    public static void main(String[] args) {
        Cart anOrder = new Cart();
        DVD dvd1 = new DVD("The Lion King", "Animation", "Roger Allers", 87, 19.95);
        DVD dvd2 = new DVD("Star Wars", "Science Fiction", "George Lucas", 87, 24.95);
        DVD dvd3 = new DVD("Aladdin", "Animation", 18.99);
        anOrder.addDVD(dvd1);
        anOrder.addDVD(dvd2);
        anOrder.addDVD(dvd3);
        System.out.println("Total Cost is: " + anOrder.totalCost());

        if (anOrder.removeDVD(dvd2)) {// Remove DVD and print total cost after removal
            System.out.println("Total Cost after removal: " + anOrder.totalCost());
        }
    }
}    
