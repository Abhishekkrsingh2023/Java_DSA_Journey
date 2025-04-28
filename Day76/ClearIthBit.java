public class ClearIthBit {
    public static void main(String[] args) {
        int num = 13, i = 2;
        System.out.println(num & (~(1 << i)));
    }
}
