package priceengine;

import fruits.Cherry;

import java.util.ArrayList;
import java.util.List;

public class CherryDecorator extends Cherry {

    List<Cherry> cherries = new ArrayList<>();

    public CherryDecorator() {
    }

    public void addCherry(Cherry c) {
        this.cherries.add(c);
    }

    @Override
    public float getPrice() {
        float discount = 20;
        if (cherries.size() < 1)
            return 0;
        int left = cherries.size() % 2;
        int packs = cherries.size() / 2;

        float price = ((packs * 2 * super.price) - (packs * discount) + left * super.price);
        return price;
    }
}
