import java.util.Stack; // collection library stack
public class PushAtBottom {
    public static void pushBottom(Stack<Integer>s,int item) {
        if(s.isEmpty()) {
            s.push(item);
            return;
        }
        int popEle = s.pop(); // removing the element
        pushBottom(s, item); // recursive call
        s.push(popEle); // backtracking
    }
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(3);
        s.push(2);
        s.push(1);
        System.out.println("Before : ");
        while(!s.isEmpty()) {
            System.out.println(s.pop());
        }
        s.push(3);
        s.push(2);
        s.push(1);
        pushBottom(s,4); // pushing 4 at the bottom
        System.out.println("After :");
        while(!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }
}
