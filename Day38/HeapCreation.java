public class HeapCreation {
    static class Heap {
        private int size;
        private int capacity;
        private int arr[];

        // constructor
        Heap() {
            capacity = 4;
            arr = new int[capacity];
            size = 0;
        }

        // parameterized constructor
        Heap(int capacity) {
            this.capacity = capacity;
            arr = new int[capacity];
            size = 0;
        }

        // resizes the heap
        private void resize() {
            capacity *= 2;
            int old[] = arr;
            arr = new int[capacity];
            // copying back
            for (int i = 0; i < old.length; i++) {
                arr[i] = old[i];
            }
        }

        // Insertion for Min heap
        public void insert(int data) {
            if (size == 0) {
                arr[size++] = data;
                return;
            } else if (size == capacity) {
                resize();
                insert(data);
                return;
            } else {
                int idx = size++;
                arr[idx] = data;

                while(idx != 0) {
                    int parent = (idx-1)/2;
                    // swapping
                    if(arr[idx] < arr[parent]) {
                        int temp = arr[idx];
                        arr[idx] = arr[parent];
                        arr[parent] = temp;
                    }
                    else return;
                    idx = parent;
                }
            }
        }
        // checks the root of the heap
        public int heapMin() {
            if(size == 0) return Integer.MIN_VALUE;
            else return arr[0];
        }
        // display function
        public void display() {
            for(int i=0;i<size;i++) {
                System.out.print(arr[i]+" ");
            }
            System.out.println();
        }
        //
        public int size() {
            return size;
        }
    }
    public static void main(String[] args) {
        Heap minHeap = new Heap(5);
        minHeap.insert(10);
        minHeap.insert(20);
        minHeap.insert(30);
        minHeap.insert(5);
        minHeap.insert(0);
        minHeap.insert(16);

        
        System.out.println("Min element : "+ minHeap.heapMin());
        System.out.println("size : "+ minHeap.size());
        minHeap.display();
    }
}
