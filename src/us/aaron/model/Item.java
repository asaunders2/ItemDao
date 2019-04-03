package us.aaron.model;

public class Item {
    private int productNumber;
    private String name;
    private double price;
    private boolean featured;
    private String description;
    private String image;

    public Item(int productNumber, String name, double price, boolean featured, String description, String image) {
        this.productNumber = productNumber;
        this.name = name;
        this.price = price;
        this.featured = featured;
        this.description = description;
        this.image = image;
    }


    public int getProductNumber() {
        return productNumber;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean isFeatured() {
        return featured;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }
}
