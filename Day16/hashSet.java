import java.util.HashSet; // for using the HashSet
import java.util.Iterator; // for using the Iterator obj

public class hashSet {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>(); // format of creation
        // adding element
        set.add(10);
        set.add(20);
        set.add(-5);
        set.add(16);
        set.add(10); // wont be added

        // Searching
        System.out.println(set.contains(10));

        // removing 
        set.remove(10);
        System.out.println(set.contains(10)); // false

        // checking size
        System.out.println(set.size()); // 3

        // Iterating the set
        Iterator it = set.iterator();
        while (it.hasNext()) {
            System.out.print(it.next()+" "); 
        }

    }
}
