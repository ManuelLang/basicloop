import fruits.*;

import javax.naming.OperationNotSupportedException;

public class FruitsParser {

    public Fruit parseFruit(String type) throws OperationNotSupportedException {
        switch (type) {
            case "Apple":
                return new Apple();
            case "Banana":
                return new Banana();
            case "Cherry":
                return new Cherry();
            case "Mele":
                return new Mele();
            default:
                throw new OperationNotSupportedException(String.format("The fruit %s is not supported", type));
        }
    }
}
