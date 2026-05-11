package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
    private static int nbDigitalVideoDiscs = 0;
    // updated constructor
    public DigitalVideoDisc(String title) {
        super(++nbDigitalVideoDiscs, title, null, 0.0f, null, 0);
    }
    public DigitalVideoDisc(String title, String category, float cost) {
        super(++nbDigitalVideoDiscs, title, category, cost, null, 0);
    }
    public DigitalVideoDisc(String title, String category, String director, float cost) {
        super(++nbDigitalVideoDiscs, title, category, cost, director, 0);
    }
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(++nbDigitalVideoDiscs, title, category, cost, director, length);
    }
@Override
    public void play() {
    if (this.getLength() > 0) {
        System.out.println("Playing track: " + this.getTitle());
        System.out.println("Track length: " + this.getLength());
    } else {
        System.out.println("ERROR: Track length is invalid.");
    }
}
@Override
    public String toString() {
    return "DVD: " + this.getTitle() + " - " + this.getCategory() + " - " + this.getDirector() + " - " + this.getLength() + " min: " + this.getCost() + " $";
    }
}
