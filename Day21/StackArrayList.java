import java.util.ArrayList; // for using Array list
public class StackArrayList {
    // stack class
    static class Stack {
        ArrayList<Integer> s = new ArrayList<>();

        // isempty function
        public boolean isEmpty() {
            return s.size() == 0;
        }

        // push/add
        public void push(int val) {
            s.add(val);
        }
        // pop
        public int pop() {
            if (isEmpty()) {
                System.out.println("Stack is empty");
                return Integer.MIN_VALUE;
            }
            else return s.removeLast();
        }
        // peek()/top
        public int peek() {
            if (isEmpty()) {
                System.out.println("Stack Empty");
                return Integer.MIN_VALUE;
            }
            return s.get(s.size()-1);
        }
    }
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(10);
        s.push(20);
        s.push(30);

        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.peek());
        System.out.println(s.pop());

        s.peek();
        s.pop();
    }
}
