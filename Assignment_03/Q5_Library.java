package Assignment_03;

class Book {
    private String title;
    private String author;
    private double price;

    public Book(String t, String a, double p) {
        title = t;
        author = a;
        price = p;
    }

    // Getter & Setter
    public String getTitle() {
        return title;
    }

    public void setTitle(String t) {
        title = t;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String a) {
        author = a;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double p) {
        price = p;
    }

    void display() {
        System.out.println(title + " by " + author + " - Rs." + price);
    }
}

public class Q5_Library {
    public static void main(String[] args) {
        Book b1 = new Book("Java Basics", "James Gosling", 450);
        b1.display();
        b1.setPrice(500);
        b1.display();
    }
}