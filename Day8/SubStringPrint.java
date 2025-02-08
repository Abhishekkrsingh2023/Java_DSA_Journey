
public class SubStringPrint {
    public static void main(String[] args) {
        String str = "ABCD";

        // Printing the substring
        for(int i = 0;i<str.length();i++) {
            for(int j = i+1;j<=str.length();j++) {
                System.out.println(str.substring(i,j));
            }
        }
    }
}
