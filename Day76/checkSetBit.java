public class checkSetBit {
    public static boolean isSet(int num, int i) {
        int x = 1 << i;
        return (num & x) == x ? true : false;
    }

    public static void main(String[] args) {
        int num = 13, i = 2;
        System.out.println(isSet(num, i));
        System.out.println(isSet(num, 1));

        // using the right shift
        if (((num >> i) & 1) == 1)
            System.out.println("true");
        else
            System.out.println("false");
    }
}
