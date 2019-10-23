package fruits;

public class Cherry extends Fruit {

    public Cherry() {
        this(Cherry.class.getName());
    }

    public Cherry(String name){
        super(75, name);
    }
}
