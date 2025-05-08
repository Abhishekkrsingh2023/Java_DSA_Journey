import java.util.Arrays;

public class MaxStringLen {
    public static int getMaxLen(String str) {
        int l = 0, r = 0, maxLen = 0, len = 0;
        int n = str.length();
        int[] hash = new int[256];
        Arrays.fill(hash, -1);

        while (r < n) {
            // if the char is already seen
            if (hash[str.charAt(r)] != -1) {
                if (hash[str.charAt(r)] >= l) {
                    // move l
                    l = hash[str.charAt(r)] + 1;
                }
            }
            len = r - l + 1;
            maxLen = Math.max(maxLen, len);
            hash[str.charAt(r)] = r;
            r++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String st = "abcdaefgcbaxy";
        System.out.println(getMaxLen(st));
    }
}
