public class CountZeroes {
    public static int getCount(int num) {
        if(num == 0) return 1; // if the number is zero;
        if(num < 10) return 0; // if the number is 1 digit

        if(num%10 == 0) {
            return 1+ getCount(num/10);
        }
        else {
            return getCount(num/10);
        }
    }
    public static void main(String[] args) {
        System.out.println(getCount(1520036));
    }
}
