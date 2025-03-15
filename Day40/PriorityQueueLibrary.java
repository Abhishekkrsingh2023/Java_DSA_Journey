
import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueueLibrary {
	public static void main(String[] args) {
        // Min priority queue
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // Max priority queue
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        // MinHeap(Min priority queue)
        minHeap.add(10);
        minHeap.add(5);
        minHeap.add(11);
        minHeap.add(33);
        while (!minHeap.isEmpty()) {
            System.err.print(minHeap.peek()+ " ");
            minHeap.remove();
        }
        System.out.println();
        // Maxheap(Max priority queue)
        maxHeap.add(10);
        maxHeap.add(5);
        maxHeap.add(11);
        maxHeap.add(33);

        while (!maxHeap.isEmpty()) {
            System.err.print(maxHeap.peek()+ " ");
            maxHeap.remove();
        }

    }
}
