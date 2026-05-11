package hust.soict.dsai.aims.media;
import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    @Override
    public int compare(Media m1, Media m2) {
        // Compare by title in ascending order
        int titleDiff = m1.getTitle().compareToIgnoreCase(m2.getTitle());
        if (titleDiff != 0) {
            return titleDiff;
        }
        // Compare by cost in descending order
        return Float.compare(m2.getCost(), m1.getCost());
    }
}