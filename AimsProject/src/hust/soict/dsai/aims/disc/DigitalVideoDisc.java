package hust.soict.dsai.aims.disc;
public class DigitalVideoDisc {
    private String title;
    private String category;
    private String director;
    private int length;
    private double cost;
	private int id;
    private static int nbDigitalVideoDiscs = 0;
	public DigitalVideoDisc(String title) {
		this.title = title;
	}
	public DigitalVideoDisc(String title, String category, double cost) {
		this.title = title;
		this.category = category;
		this.cost = cost;
		nbDigitalVideoDiscs++;
    	this.id = nbDigitalVideoDiscs;
	}
	public DigitalVideoDisc(String title, String category, String director, double cost) {
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
		nbDigitalVideoDiscs++; 
    	this.id = nbDigitalVideoDiscs;
	}
	public DigitalVideoDisc(String title, String category, String director, int length, double cost) {
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
		nbDigitalVideoDiscs++; 
    	this.id = nbDigitalVideoDiscs;
	}
    
	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public double getCost() {
		return cost;
	}
    public void setTitle(String title) {
        this.title = title;
	}
	public int getId() {
    return id;
	}
	@Override
    public String toString() {
        return "DVD - " + title + " - " + cost + " $";
    }
	public boolean isMatch(String title) {
    return this.title.toLowerCase().contains(title.toLowerCase());
}
}
