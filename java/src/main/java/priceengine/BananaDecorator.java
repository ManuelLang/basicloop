package priceengine;

import fruits.Banana;
import fruits.Cherry;

import java.util.ArrayList;
import java.util.List;

public class BananaDecorator extends Banana {

    List<Banana> bananas = new ArrayList<>();

    public BananaDecorator() {
    }

    public void addBanana(Banana b) {
        this.bananas.add(b);
    }

    @Override
    public float getPrice() {
        float discount = super.price;
        if (bananas.size() < 1)
            return 0;
        int left = bananas.size() % 2;
        int packs = bananas.size() / 2;

        float price = ((packs * 2 * super.price) - (packs * discount) + left * super.price);
        return price;
    }
}