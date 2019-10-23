package priceengine;

import fruits.Apple;
import fruits.Banana;

import java.util.ArrayList;
import java.util.List;

public class AppleDecorator extends Apple {

    List<Apple> apples = new ArrayList<>();

    public AppleDecorator() {
    }

    public void addApple(Apple a) {
        this.apples.add(a);
    }

    @Override
    public float getPrice() {
        float packPrice = 2;
        int packNumber = 3;

        if (apples.size() < 1)
            return 0;
        int left = apples.size() % packNumber;
        int packs = apples.size() / packNumber;

        float price = (packs * packPrice + left * super.price);
        return price;
    }
}
