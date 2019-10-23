package fruits;

public abstract class Fruit {

    protected float price;
    protected String name;

    protected Fruit() {
    }

    protected Fruit(String name) {
        this(0, name);
    }

    public Fruit(float price, String name) {
        this.price = price;
        this.name = name;
    }

    public float getPrice() {
        return this.price;
    }

    public String getName() {
        return this.name;
    }
}
