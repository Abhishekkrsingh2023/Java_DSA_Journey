import java.util.ArrayList;

public class IteratingArrayList {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        // adding names
        names.add("Abhishek");
        names.add("Sam");
        names.add("Yanger");
        // iterating uisng for-each loop
        for(String name : names) {
            System.out.println(name);
        }
    }
}
