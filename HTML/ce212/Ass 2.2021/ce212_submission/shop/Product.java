package shop;

public class Product {
    public final String PID;
    public final String artist;
    public final String title;
    public final String description;
    public int price;
    public final String thumbnail;
    public final String full_image;

    public Product(String PID, String artist, String title, String description, int price, String thumbnail,
                   String full_image) {
        this.PID = PID;
        this.artist = artist;
        this.title = title;
        this.description = description;
        this.price = price;
        this.thumbnail = thumbnail;
        this.full_image = full_image;
    }


    public String toString(int price) {
        this.price = price;
        int pounds = price / 100;
        int pence = (int) (price * 100 + 0.01);
        pence = pence % 100;

        return pounds + "." + pence;


    }


}
