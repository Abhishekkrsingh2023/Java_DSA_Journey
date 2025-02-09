// package Day9;

public class StringCompression {
    public static void main(String[] args) {
        String str = "aabcccdeeeeefg";
        StringBuilder ans = new StringBuilder("");
        ans.append(str.charAt(0)+"");
        int count = 1;

        for(int i=1;i<str.length();i++) {
            char curr = str.charAt(i);
            char prev = str.charAt(i-1);

            if(prev == curr) {
                count++;
            }
            else {
                if(count > 1) 
                    ans.append(count); // count
                ans.append(curr);
                count=1; // resetting the count
            }
        }
        if(count > 1) ans.append(count); // for the last case
        System.out.println(ans);
    }
}
