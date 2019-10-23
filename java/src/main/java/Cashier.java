import fruits.Fruit;

import java.util.ArrayList;
import java.util.List;

public class Cashier {

    private List<Fruit> fruits = new ArrayList<Fruit>();

    public Cashier() {
    }

    public void addFruit(Fruit f) {
        if (!fruits.contains(f))
            fruits.add(f);
    }

    public float getPrice() {
        float price = 0;
        for (Fruit f : fruits) {
            price += f.getPrice();
        }
        return price;
    }
}
