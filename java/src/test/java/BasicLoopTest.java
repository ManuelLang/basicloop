import fruits.Apple;
import fruits.Banana;
import fruits.Cherry;
import fruits.Fruit;
import org.junit.Test;
import priceengine.BananaDecorator;
import priceengine.CherryDecorator;

import javax.naming.OperationNotSupportedException;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BasicLoopTest {


    @Test
    public void should_handle_input() {
        assertThat(new BasicLoop().doSomethingWithInput("foobar")).isEqualTo("< foobar");
    }

    @Test
    public void should_parseFruits() throws OperationNotSupportedException {
        BasicLoop bl = new BasicLoop();
        List<Fruit> fruits = bl.parseFruits("Mele,Apple");
        for(Fruit f : fruits) {
            System.out.println(f.getName());
        }
    }

    @Test
    public void should_bill_cherry_price() {
        Cashier cash = new Cashier();
        cash.addFruit(new Cherry());
        assertThat(cash.getPrice()).isEqualTo(75);
    }

    @Test
    public void should_bill_apple_price() {
        Cashier cash = new Cashier();
        cash.addFruit(new Apple());
        assertThat(cash.getPrice()).isEqualTo(200);
    }

    @Test
    public void should_bill_banana_price() {
        Cashier cash = new Cashier();
        cash.addFruit(new Banana());
        assertThat(cash.getPrice()).isEqualTo(150);
    }

    @Test
    public void should_sum_apples() {
        Cashier cash = new Cashier();
        cash.addFruit(new Apple());
        cash.addFruit(new Cherry());
        cash.addFruit(new Cherry());
        int price = (int)cash.getPrice();
        assertThat(price).isEqualTo(350);
    }

    @Test
    public void should_earn_on_cherry() {
        Cashier cash = new Cashier();
        CherryDecorator cd = new CherryDecorator();
        cd.addCherry(new Cherry());
        cash.addFruit(cd);
        assertThat(cash.getPrice()).isEqualTo(75);
    }

    @Test
    public void should_earn_on_cherries() {
        Cashier cash = new Cashier();
        CherryDecorator cd = new CherryDecorator();
        cd.addCherry(new Cherry());
        cd.addCherry(new Cherry());
        cash.addFruit(cd);
        assertThat(cash.getPrice()).isEqualTo(130);
    }

    @Test
    public void should_earn_on_banana() {
        Cashier cash = new Cashier();
        BananaDecorator bd = new BananaDecorator();
        bd.addBanana(new Banana());
        cash.addFruit(bd);
        assertThat(cash.getPrice()).isEqualTo(150);
    }

    @Test
    public void should_earn_on_bananas() {
        Cashier cash = new Cashier();
        BananaDecorator bd = new BananaDecorator();
        bd.addBanana(new Banana());
        bd.addBanana(new Banana());
        cash.addFruit(bd);
        assertThat(cash.getPrice()).isEqualTo(150);
    }

    @Test
    public void should_sum_with_discount() {
        Cashier cash = new Cashier();

        CherryDecorator cd = new CherryDecorator();
        cd.addCherry(new Cherry("Cerise"));
        cd.addCherry(new Cherry("Cerise"));
        cash.addFruit(cd);

        BananaDecorator bd = new BananaDecorator();
        bd.addBanana(new Banana("Banane"));
        bd.addBanana(new Banana("Banane"));
        cash.addFruit(bd);

        assertThat(cash.getPrice()).isEqualTo(280);
    }

    @Test
    public void should_change_name() {
        String name = "Banane";
        Banana b = new Banana(name);
        assertThat(b.getName()).isEqualTo(name);
    }

}