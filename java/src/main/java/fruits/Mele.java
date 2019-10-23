package fruits;

public class Mele extends Fruit {

    public Mele() {
        this(Mele.class.getName());
    }

    public Mele(String name) {
        super(100, name);
    }
}
