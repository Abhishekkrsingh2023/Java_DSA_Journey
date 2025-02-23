public class StackUsingArray {
    static class Stack {
        private int[] stk;
        private int top;

        Stack(int n) {
            stk = new int[n];
            top = -1; // no element
        }
        // isEmpty function
        public boolean isEmpty() {
            return top == -1;
        }
        // push operation
        public void push(int val) {
            if(top+1 == stk.length) {
                System.out.println("OverFlow");
            }
            else {
                stk[++top] = val;
            }
        }
        // pop 
        public int pop() {
            if (isEmpty()) {
                System.out.println("UnderFlow");
                return Integer.MIN_VALUE;
            }
            return stk[top--];
        }
        // peek
        public int peek() {
            if (isEmpty()) {
                System.out.println("Stack is empty");
                return Integer.MIN_VALUE;
            }
            return stk[top];
        }

    }
    public static void main(String[] args) {
        Stack s = new Stack(5); // stack array of size 5
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        s.push(50);
        s.push(100); // overflow

        // printing the elements
        while(!s.isEmpty()) {
            System.out.print(s.pop()+" ");
        }
        System.out.println(s.peek()); // top element
    }
}