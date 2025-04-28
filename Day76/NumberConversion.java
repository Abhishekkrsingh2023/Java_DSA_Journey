
public class NumberConversion {
    // Decimal To Binary Conversion
    public static String decimalToBinary(int n) {
        String binary = "";
        while (n > 0) {
            int rem = n % 2;
            binary += rem;
            n = n / 2;
        }
        // Reverse the string to get the correct binary representation
        StringBuilder sb = new StringBuilder(binary);
        binary = sb.reverse().toString();
        return binary;
    }

    // Binary To Decimal Conversion
    public static int getDecimal(String binary) {
        int decimal = 0;
        int pow = 1;
        for (int i = binary.length() - 1; i >= 0; i--) {
            int digit = binary.charAt(i) - '0'; // fix here: convert '0'/'1' to 0/1
            decimal += digit * pow;
            pow <<= 1;
        }
        return decimal;
    }

    public static void main(String[] args) {
        System.out.println(decimalToBinary(12)); // Output: 1100
        System.out.println(decimalToBinary(15)); // Output: 1111
        System.out.println(decimalToBinary(255)); // Output: 11111111

        System.out.println();
        System.out.println(getDecimal("100"));
        System.out.println(~5);
        System.out.println(decimalToBinary(13));
    }
}
