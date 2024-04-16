package Algorithms.lab3;

import OOP.lab3.Complexn;

public class shopkeeper {

    public static void main(String[] args) {
        Item[] items = {
                new Item(1, "pencil", 2, 124),
                new Item(2, "pen", 14, 35),
                new Item(3, "notebook", 40, 26),
                new Item(4, "eraser", 22, 43),
                new Item(5, "ruler", 43, 14)
        };
        System.out.printf("Max profit: %d", ItemsFuncions.maxProfit(items));
    }
}
