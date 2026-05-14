package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    private List<String> authors = new ArrayList<String>();
    private int contentLength;

    public Book() {
        super();
    }

    public Book(int id, String title, String category, float cost) {
        super(id, title, category, cost);
        this.contentLength = 0;
    }

    public Book(int id, String title, String category, float cost, int contentLength) {
        super(id, title, category, cost);
        this.contentLength = contentLength;
    }

    public int getContentLength() {
        return contentLength;
    }

    public void setContentLength(int contentLength) {
        this.contentLength = contentLength;
    }

    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
            System.out.println("Added author: " + authorName);
        } else {
            System.out.println("Author '" + authorName + "' is already in the list.");
        }
    }

    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) {
            authors.remove(authorName);
            System.out.println("Removed author: " + authorName);
        } else {
            System.out.println("Author '" + authorName + "' not found in the list.");
        }
    }

    @Override
    public String toString() {
        return "Book: "+ this.getTitle()+ " - "+ this.getCategory()+ " - Authors: "+ authors.toString()+ " - Content length: "+ this.getContentLength()+ " tokens"+ " - "+ this.getCost()+ " $";
    }
}