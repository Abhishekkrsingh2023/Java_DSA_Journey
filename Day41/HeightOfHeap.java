public class HeightOfHeap {
    public static int findHeapHeight(int[] heap) {
        // If heap is empty
        if (heap == null) {
            return 0;
        }
        if(heap.length == 1) return 1;
        return (int) Math.floor(Math.log(heap.length) / Math.log(2));
    }

    public static void main(String[] args) {
        // Example heap array
        int[] heap = {100, 50, 30, 20, 15, 10, 8};
        
        int height = findHeapHeight(heap);
        System.out.println("Height of the heap: " + height);
    }
}