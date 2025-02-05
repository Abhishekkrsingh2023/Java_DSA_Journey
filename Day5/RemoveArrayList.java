import java.util.ArrayList;

public class RemoveArrayList {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        // adding names
        names.add("Abhishek");
        names.add("Sam");
        names.add("Yanger");
        // displaying
        for(String name : names) {
            System.out.println(name);
        }

        // removing arraylist element from index
        System.out.println("\nAfter removing");
        names.remove(1);
        for(String name : names) {
            System.out.println(name);
        }
    }
}
