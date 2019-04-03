package us.aaron.model;

import java.util.ArrayList;
import java.util.List;

public class ItemCatalog {
    private List<Item> itemCatalog = new ArrayList<>();
    private int nextProductNumber;

    public ItemCatalog() {
        nextProductNumber = 1;
        itemCatalog.add(new Item(nextProductNumber++,
                "Fortnite",
                0.99,
                true,
                "Fortnite is a Battle Royal game <br>Play against 99 other players in a 100 player death match, alone or with friends",
                "images/game1.jpg"));
        itemCatalog.add(new Item(nextProductNumber++,
                "Pool",
                35.25,
                true,
                "Classic Pool game online",
                "images/game2.jpg"));
        itemCatalog.add(new Item(nextProductNumber++,
                "Zumba",
                1.99,
                true,
                "Color Matching game",
                "images/game3.jpg"));
        itemCatalog.add(new Item(nextProductNumber++,
                "Mario Cart",
                59.99,
                true,
                "Newest Mario Cart racing game<br>Play with friends online in head to head races",
                "images/game4.jpg"));
    }

    public List<Item> getItemCatalog() {
        return itemCatalog;
    }

    public List<Item> getFeaturedItemCatalog() {
        List<Item> item = new ArrayList<>();

        for(Item i: itemCatalog) {
            if (i.isFeatured()) {
                item.add(i);
            }
        }
        return item;
    }
    public Item getSingleItem(int itemNum) {
        Item item=null;

        for(Item i: itemCatalog) {
            if (i.getProductNumber() == itemNum) {
                return i;
            }
        }
        return item;
    }
}
