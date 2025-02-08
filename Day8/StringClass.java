
public class StringClass {
    public static void main(String[] args) {
        String str = "Hello"; // String object
        String str2 = new String("Hello");
        System.out.println(str);
        System.out.println(str.equals(str2)); // true
        System.out.println(str.length()); // 5
        System.out.println(str.charAt(1)); // 'e'
        System.out.println(str.substring(1, 4)); // "ell"
        System.out.println(str.toUpperCase()); // "HELLO"
        System.out.println(str.replace('l', 'p')); // "Heppo"
    }
}