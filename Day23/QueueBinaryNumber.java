// package Day23;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class QueueBinaryNumber {
    // returns an ArrayList of String
    static ArrayList<String> getBinary(int n) {
        if(n<1) return null;
        ArrayList<String> ans = new ArrayList<>();
        Queue<String> q = new LinkedList<>();

        q.add("1"); // initially 1
        ans.add("1");
        int count = 1;
        while(ans.size() < n) {
            String curr = q.remove();
            ans.add(curr+"0");
            if(ans.size() < n) // edge case
                ans.add(curr+"1");
            q.add(ans.get(count++));
        }
        return ans;
    }
    public static void main(String[] args) {
        ArrayList<String> ans = getBinary(16);
        System.out.println(ans);
    }
}
