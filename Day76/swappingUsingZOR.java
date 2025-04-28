public class swappingUsingZOR {
    public static void main(String[] args) {
        int a = 5, b = 6;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println(a +" "+ b);
    }
}
