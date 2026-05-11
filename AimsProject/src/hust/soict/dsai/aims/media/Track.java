package hust.soict.dsai.aims.media;

public class Track implements Playable{
    private String title;
    private int length;

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }
    public String getTitle() {
        return title;
    }
    public int getLength() {
        return length;
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
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        if(obj == null || !(obj instanceof Track)) {
            return false;
        }
        Track other = (Track) obj;
        return length == other.length && (title != null && title.equalsIgnoreCase(other.title));
    }
}