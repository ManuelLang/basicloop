package fruits;

public class Apple extends Fruit {

    public Apple() {
        this(Apple.class.getName());
    }

    public Apple(String name) {
        super(200, name);
    }
}
