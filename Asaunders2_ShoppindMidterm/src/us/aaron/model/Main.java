package us.aaron.model;

public class Main {
    public static void main(String[] args) {
        String breaker = "==============================\n";

        ItemDao itemDao = new ItemDaoImpl();
        for (Item item : itemDao.getAllItems()) {
            System.out.println("\n" + breaker +
                    "Item " + item.getProductNumber() + "\n" +
                    "Name : " + item.getName() + "\n" +
                    "Price : " + item.getPrice() + "\n" +
                    "Description : " + item.getDescription() + "\n" +
                    breaker);
        }
        Item item = itemDao.getAllItems().get(0);
        item.setName("Another Game");
        itemDao.updateItem(item);
        itemDao.getItem(0);
        System.out.println("\n" + breaker +
                "Item " + item.getProductNumber() + "\n" +
                "Name : " + item.getName() + "\n" +
                "Price : " + item.getPrice() + "\n" +
                "Description : " + item.getDescription() + "\n" +
                breaker);
    }
}
