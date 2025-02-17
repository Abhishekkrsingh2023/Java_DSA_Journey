import java.util.HashMap; // for using HashMap
import java.util.Map; // map interface
import java.util.Set; // for using set interface

public class hashMapClass {
    public static void main(String[] args) {
        // rollNo(Key) , Name(Value)
        HashMap<Integer,String> map = new HashMap<>();

        // Insertion
        map.put(20,"Abhi");
        map.put(50,"Sumit");
        map.put(33,"Arvind");
        map.put(66,"Alex");
        map.put(20,"Akshay"); // replaces "Abhi" -> "Akshay"

        // getting the values
        System.out.println(map.get(33));
        System.out.println(map.get(40)); // null (No values exists)
        

        // size
        System.out.println(map.size()); // 4

        // getting the key set
        System.out.println(map.keySet());

        // Iterating (Method 1)
        for(Map.Entry<Integer,String> e:map.entrySet()) {
            System.out.println(e.getKey()+ " : "+ map.get(e.getKey())); // key - value
        }
        // Iterating (Method 2)
        System.out.println();
        Set<Integer> Keys = map.keySet();
        for(Integer key : Keys) {
            System.out.println(key+" : "+map.get(key)); // key - value
            
        }

        // Removing
        map.remove(20);
    }
}
