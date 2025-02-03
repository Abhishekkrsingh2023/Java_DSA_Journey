public class ReversingString {

    public static String revString(String str ,int idx, String newStr) {
        if(str.length()==0 || idx == str.length()) return "";
        newStr = revString(str, idx+1, newStr);
        newStr += str.charAt(idx);
        return newStr;
    }
    public static void main(String[] args) {
       System.out.println(revString("hello", 0, ""));
    }
}