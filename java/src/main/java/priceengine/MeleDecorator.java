package priceengine;

import fruits.Mele;

import java.util.ArrayList;
import java.util.List;

public class MeleDecorator extends Mele {

    List<Mele> meles = new ArrayList<>();

    public MeleDecorator() {
    }

    public void addMele(Mele a) {
        this.meles.add(a);
    }

    @Override
    public float getPrice() {
        float packPrice = 1;
        int packNumber = 2;
        if (meles.size() < 1)
            return 0;
        int left = meles.size() % packNumber;
        int packs = meles.size() / packNumber;

        float price = (packs * packPrice + left * super.price);
        return price;
    }
}