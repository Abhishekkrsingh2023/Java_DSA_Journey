// package Day24;
import java.util.Stack;

public class ValidString {
    // for opening bracket
    public static boolean isOpening(char ch) {
        return (ch == '{' || ch == '[' || ch =='(');
    }
    // valid string
    public static boolean isValid(String str) {
        Stack<Character>st = new Stack<>();
        for(int i=0;i<str.length();i++) {
            char ch = str.charAt(i);
            if(isOpening(ch)) {
                st.push(ch);
            }
            else {
                if(st.isEmpty()) return false;
                // checking for matching brackets
                if((st.peek() =='{' && ch == '}')||
                (st.peek() =='[' && ch == ']')||
                (st.peek() =='(' && ch == ')')){
                    st.pop();
                }
                else {
                    return false;
                }
            }
        }
        return st.isEmpty(); // checking for leftouts
    }
    public static void main(String[] args) {
        String str = "]";
        System.out.println(isValid(str));
    }
}
