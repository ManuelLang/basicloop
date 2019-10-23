package fruits;

public class Banana extends Fruit {

    public Banana() {
        this(Banana.class.getName());
    }

    public Banana(String name) {
        super(150, name);
    }
}
