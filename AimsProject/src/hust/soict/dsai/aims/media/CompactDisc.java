package hust.soict.dsai.aims.media;
import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private List<Track> tracks = new ArrayList<Track>();
    public CompactDisc(int id, String title, String category, float cost, String director, String artist) {
        super(id, title, category, cost, director, 0); 
        this.artist = artist;
}
    public String getArtist() {
        return artist;
    }
// addTrack and removeTrack methods
    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
            System.out.println("Added track: " + track.getTitle());
        } else {
            System.out.println("Track '" + track.getTitle() + "' is already in the list.");
        }
    }
    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Removed track: " + track.getTitle());
        } else {
            System.out.println("Track '" + track.getTitle() + "' not found in the list.");
        }
    }
@Override
public void play() {
    if (this.getLength() > 0) {
        System.out.println("Playing CD: " + this.getTitle() + " by " + this.getArtist());
        System.out.println("Total length: " + this.getLength());
        for (Track track : tracks) {
            track.play();
        }
    } else {
        System.out.println("ERROR: CD length is invalid!");
    }
}
    @Override
    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }
    @Override
    public String toString() {
        return "CD: " + this.getTitle() + " - " + this.getCategory() + " - " + this.getArtist() + " - " + this.getDirector() + " - Total length: " + this.getLength() + " min: " + this.getCost() + " $";
}
}