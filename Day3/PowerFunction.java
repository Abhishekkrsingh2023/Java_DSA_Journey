public class PowerFunction {
    // Power function (a^b)
    public static int power(int base, int exp) {
        if(exp == 0) return 1;
        if(exp == 1) return base;
        int pow;
        // if the exponent is even
        if(exp%2 == 0) {
            pow = power(base, exp/2) * power(base, exp/2);
        }
        // if exponent is odd
        else {
            pow = power(base, exp/2) * power(base, exp/2) * base;
        }
        return pow;
    } 
    public static void main(String[] args) {
        System.out.println(power(3, 5)); // 3^5 = 243
    }
}