import java.util.ArrayList; // For using ArrayList

public class ArrayListCreation {
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
    }
}
