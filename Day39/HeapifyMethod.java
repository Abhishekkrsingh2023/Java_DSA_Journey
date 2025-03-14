// package Day39;

import java.util.ArrayList;
import java.util.Scanner;

// assuming for min heap
public class HeapifyMethod {
    ArrayList<Integer> list;

    public HeapifyMethod(ArrayList<Integer> list) {
        this.list = list;
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
    // heapify each element for n/2 to 0 index
    public void Heapify() {
        // base case
        if(list == null) return;

        int start = (list.size() / 2)-1;
        for (int i = start; i >= 0; i--) {
            downHeap(i);
        }
    }
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of arrayList : ");
        int n = sc.nextInt();
        System.out.println("Enter the "+n+" elements :");
        for(int i=0;i<n;i++) {
            arr.add(sc.nextInt());
        }
        System.out.println("Before Heapifying : ");
        System.out.println(arr);
        // heapify
        HeapifyMethod minHeap = new HeapifyMethod(arr);
        minHeap.Heapify();

        System.out.println("After Heapifying : ");
        System.out.println(arr);
    }
}
