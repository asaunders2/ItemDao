package us.aaron.model;

import java.util.ArrayList;
import java.util.List;

public class ItemDaoImpl implements ItemDao{

    //list is working as a database
    List<Item> items;
    public ItemDaoImpl(){
        items = new ArrayList<Item>();
        Item item1 = new Item(1,
                "Fortnite",
                0.99,
                true,
                "Fortnite is a Battle Royal game <br>Play against 99 other players in a 100 player death match, alone or with friends",
                "images/game1.jpg");
        Item item2 = new Item(2,
                "Pool",
                35.25,
                true,
                "Classic Pool game online",
                "images/game2.jpg");
        Item item3 = new Item(3,
                "Zumba",
                1.99,
                true,
                "Color Matching game",
                "images/game3.jpg");
        Item item4 = new Item(4,
                "Mario Cart",
                59.99,
                true,
                "Newest Mario Cart racing game<br>Play with friends online in head to head races",
                "images/game4.jpg");
        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);
    }

    @Override
    public void deleteItem(Item item) {
        items.remove(item.getProductNumber());
        System.out.println("Item: Product No " + item.getProductNumber() +
                ", deleted from database");
    }

    @Override
    public List<Item> getAllItems() {
        return items;
    }

    @Override
    public Item getItem(int prodNo) {
        return items.get(prodNo);
    }
    @Override
    public void updateItem(Item item) {
        items.get(item.getProductNumber()).setName(item.getName());
        System.out.println("Item: Product No " + item.getProductNumber() +
                ", updated in the database");
    }
}