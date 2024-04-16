package Algorithms.lab3;

public class ItemsFuncions extends Item {
    public ItemsFuncions(int id, String name, int price, int quantity) {
        super(id, name, price, quantity);
    }
    public static int maxProfit (Item[] items) {
        int max = 0;
        for(int i = 0; i < items.length; i++) {
           max += (items[i].getPrice()*items[i].getQuantity());
        }
        return max;
    }
}
