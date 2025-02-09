// package Day9;

import java.util.Scanner;

public class ToggleString {
    // function to toggle the characters 
    public static void toggleStr(StringBuilder str) {
        if(str.length() == 0) return; // null string
        char ch;
        for(int i=0; i<str.length(); i++) {
            ch = str.charAt(i);

            // For Lower --> Upper
            if(ch >= 97 && ch <= 122) {
                char letter = (char)(ch - 32);
                str.setCharAt(i, letter);
            }

            // for Upper --> Lower
            if(ch >= 65 && ch <= 90) {
                char letter = (char)(ch + 32);
                str.setCharAt(i, letter);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a String : ");
        StringBuilder str = new StringBuilder(sc.next()); 
        toggleStr(str);
        System.out.println(str);
    }
}
