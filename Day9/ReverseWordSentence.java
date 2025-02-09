// package Day9;

public class ReverseWordSentence {
    public static void main(String[] args) {
        String str = "I Love coding in Java";
        StringBuilder word = new StringBuilder("");
        String ans = "";

        for(int i=0;i<str.length();i++) {
            char ch = str.charAt(i);
            if(ch != ' ') {
                word.append(str.charAt(i));
            }
            // after encountring space
            else {
                word.reverse();
                ans += (word + " ");
                word.delete(0, word.length());
            }
        }
        // for the last word
        ans = ans + word.reverse();
        System.out.println(ans);
    }
}
