import java.util.ArrayList;
import java.util.Stack;

public class StockSpan {
    public static ArrayList<Integer> getSpan(int[] price) {
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> s = new Stack<>(); // stack for previous peak
        for(int i=0;i<price.length;i++) {
            while(s.size()>0 && price[s.peek()] <= price[i]) {
                s.pop();
            }
            if(s.size()==0) ans.add(i+1);
            else {
                ans.add(i-s.peek());
            }
            s.push(i);
        }
        return ans;
    }
    public static void main(String[] args) {
        int price[] = {100,80,60,70,60,75,85};
        ArrayList<Integer> ans = getSpan(price);
        for(int ele:ans) {
            System.out.print(ele+" ");
        }
    }
}