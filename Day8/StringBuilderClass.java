
public class StringBuilderClass {
    public static void main(String[] args) {
        StringBuilder str;
        str = new StringBuilder("hello");
        
        System.out.println(str);

        str.setCharAt(1, 'i'); // mutable
        System.out.println(str);
        str.append(" world");
        System.out.println(str);

        str.insert(5, ",");
        System.out.println(str);

        str.delete(5, 6);
        System.out.println(str);

        str.reverse();
        System.out.println(str);
    }
}