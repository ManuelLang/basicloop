import fruits.Fruit;

import javax.naming.OperationNotSupportedException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BasicLoop {

    public void loop() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("> ");
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            System.out.println(doSomethingWithInput(input));
            System.out.print("> ");
        }
    }

    public String doSomethingWithInput(String input) {
        return "< " + input;
    }

    public List<Fruit> parseFruits(String fruits) throws OperationNotSupportedException {
        FruitsParser fp = new FruitsParser();
        List<Fruit> fruitList = new ArrayList<>();
        for (String f : fruits.split(",")) {
            fruitList.add(fp.parseFruit(f));
        }
        return fruitList;
    }

    public static void main(String[] args) {
        BasicLoop bl = new BasicLoop();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            List<Fruit> fruits = bl.parseFruits(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (OperationNotSupportedException e) {
            e.printStackTrace();
        }

    }

}
