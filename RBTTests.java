package Homework4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RBTTests {
public static void main(String[] args) throws IOException {
    final rbt tree = new rbt();
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
        while (true) {
            try {
                System.out.println("ВВедите значение: ");
                int value = Integer.parseInt(reader.readLine());
                tree.add(value);
                System.out.println("done root" + tree.root);
                System.out.println(tree.treeToString(tree.getRoot()));
            } catch (Exception ignored) {

            }
        }
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}

}