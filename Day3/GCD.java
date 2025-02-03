public class GCD {
    public static int getGcd(int a,int b) {
        if(a==0 && b==0) return -1; // invalid
        if(b==0) return a; // if a=x , b=0 return x
        if(a==0) return b; // if a=0 ,b=x return x
        // when both are non zero
        return getGcd(b, a%b);
    }
    public static void main(String[] args) {
        System.out.println(getGcd(30, 33));
    }
}
