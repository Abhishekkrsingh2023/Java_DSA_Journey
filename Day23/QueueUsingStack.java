
// package Day23;
import java.util.Stack;

public class QueueUsingStack {
    static class Queue {
        // 2 stacks
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        // isempty function
        public boolean isEmpty() {
            return s1.isEmpty();
        }

        // add
        public void add(int val) {
            while (!s1.isEmpty())
                s2.push(s1.pop()); // pushing to s2
            s1.push(val);
            // pushing back to s1
            while (!s2.isEmpty())
                s1.push(s2.pop());
        }

        // remove or dequeue
        public int remove() {
            if (s1.isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            } else
                return s1.pop(); // top element
        }

        // peek / front
        public int front() {
            if (s1.isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            } else
                return s1.peek(); // top element
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(10);
        q.add(20);
        q.add(30);

        while (!q.isEmpty()) {
            System.out.println(q.remove());
        }
    }
}
