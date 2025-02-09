// package Day9;

public class PalindromicSubstring {

    // checks for palindrome
    public static boolean checkPalindrome(String str) {
        int i=0,j=str.length()-1;
        boolean flag = true;
        while (i<j) {
            if(str.charAt(i) != str.charAt(j)) {
                flag = false;
                break;
            }
            i++;
            j--;
        }
        return flag;
    }
    public static void main(String[] args) {
        String str = "abacd";
        int count=0;

        // getting all the substring
        for(int i=0;i<str.length();i++) {
            for(int j=i+1; j<=str.length();j++) {
                String sub = str.substring(i, j); // substring
                if(checkPalindrome(sub)) { // checking for palindrome
                    System.out.println(sub);
                    count++;
                }
            }
        }
        System.out.println("The number of Substrings are : "+count);
    }
}
