// package Day39;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class heapSort {
    static class Heap {
        private ArrayList<Integer> list;

        public Heap() {
            list = new ArrayList<>();
        }

        // Parent
        private int parent(int idx) {
            return (idx - 1) / 2;
        }

        // left child
        private int left(int idx) {
            return 2 * idx + 1;
        }

        // right child
        private int right(int idx) {
            return 2 * idx + 2;
        }

        // swap function
        private void swap(int first, int second) {
            int temp = list.get(first);
            list.set(first, list.get(second));
            list.set(second, temp);
        }
        // checks for empty heap
        public boolean isEmpty() {
            return list.isEmpty();
        }
        // upHeap(insertion)
        private void upHeap(int idx) {
            if (idx == 0)
                return;
            int parent = parent(idx);

            if (list.get(idx).compareTo(list.get(parent)) < 0) {
                swap(idx, parent);
                upHeap(parent);
            }
        }

        public void insert(int data) {
            list.add(data);
            upHeap(list.size() - 1);
        }

        // downHeap
        private void downHeap(int idx) {
            int min = idx;
            int left = left(idx);
            int right = right(idx);
            // left child exists and less than min
            if (left < list.size() && list.get(min).compareTo(list.get(left)) > 0) {
                min = left;
            }
            // right child exists and less than min
            if (right < list.size() && list.get(min).compareTo(list.get(right)) > 0) {
                min = right;
            }
            if (min != idx) {
                swap(idx, min);
                downHeap(min); // next down parent
            }
        }

        // remove
        public int remove() {
            if (list.isEmpty()) {
                System.out.println("heap is empty");
                return Integer.MIN_VALUE;
            }
            int temp = list.get(0); // top element
            int last = list.remove(list.size() - 1); // removing last element
            if (!list.isEmpty()) {
                list.set(0, last);
                downHeap(0);
            }
            return temp;
        }
    }
    
    public static void main(String[] args) {
        Heap minHeap = new Heap();
        minHeap.insert(10);
        minHeap.insert(1);
        minHeap.insert(20);
        minHeap.insert(2);
        minHeap.insert(33);

        // for head sort
        ArrayList<Integer> ans = new ArrayList<>();
        while(!minHeap.isEmpty()) {
            ans.add(minHeap.remove());
        }
        System.out.println("Sorted List");
        System.err.println(ans);

    }
}
