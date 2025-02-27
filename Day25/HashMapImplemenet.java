import java.util.ArrayList;
import java.util.LinkedList;

public class HashMapImplemenet {
    static class hashMap<K, V> { // Generics (user decides the type)
        class Node {
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int N;
        private int n;
        private static double THRESHOLD = 2.00;
        private LinkedList<Node>[] buckets;

        @SuppressWarnings("unchecked")
        public hashMap() {
            this.N = 4;
            n = 0;
            buckets = new LinkedList[N];
            for (int i = 0; i < N; i++) {
                buckets[i] = new LinkedList<>();
            }
        }

        // Rehashing the hashmap
        @SuppressWarnings("unchecked")
        private void rehash() {
            LinkedList<Node>[] oldBuckets = buckets;
            N *= 2; // Correctly doubling N
            buckets = new LinkedList[N]; // Ensure correct array size
            for (int i = 0; i < N; i++) {
                buckets[i] = new LinkedList<>();
            }

            // Re-inserting values
            for (LinkedList<Node> ll : oldBuckets) {
                for (Node node : ll) {
                    put(node.key, node.value);
                }
            }
        }

        // Hash function
        private int hashFunction(K key) {
            return Math.abs(key.hashCode()) % N;
        }

        // Search linked list for the key
        private int searchLL(K key, int bi) {
            LinkedList<Node> ll = buckets[bi];
            for (int i = 0; i < ll.size(); i++) {
                if (key.equals(ll.get(i).key)) { // Corrected key comparison
                    return i;
                }
            }
            return -1;
        }

        // Put method
        public void put(K key, V value) {
            int bi = hashFunction(key);
            int di = searchLL(key, bi);
            if (di == -1) {
                buckets[bi].add(new Node(key, value));
                n++;
            } else {
                buckets[bi].get(di).value = value;
            }

            double lambda = (double) n / N;
            if (lambda > THRESHOLD) {
                rehash();
            }
        }

        // Get method
        public V get(K key) {
            int bi = hashFunction(key);
            int di = searchLL(key, bi);
            if (di == -1) {
                return null;
            } else {
                return buckets[bi].get(di).value;
            }
        }

        // contains key function
        public boolean containsKey(K key) {
            int bi = hashFunction(key);
            int di = searchLL(key, bi);
            if (di == -1) {
                return false;
            } else {
                return true;
            }
        }
        // remove
        public V remove(K key) {
            int bi = hashFunction(key);
            int di = searchLL(key, bi);
            if (di == -1) {
                return null;
            } else {
                Node node = buckets[bi].remove(di);
                return node.value;
            }
        }
        // isEmpty
        public boolean isEmpty() {
            return n == 0;
        }
        // keySet
        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();
            for(int i=0;i<buckets.length;i++) {
                LinkedList<Node>ll = buckets[i];
                for(int j=0;j<ll.size();j++) {
                    Node node = ll.get(j);
                    keys.add(node.key);
                }
            }
            return keys;
        }
    }

    public static void main(String[] args) {
        hashMap<Integer, String> map = new hashMap<>();
        map.put(5, "Sumit");
        map.put(166, "Abhishek");
        map.put(256, "Arvind");
        map.put(88, "Suman");
        map.put(2654, "Suvadwip");

        System.out.println(map.get(12)); // Expected output: null
        System.out.println(map.get(256)); // Expected output: Arvind
        System.out.println(map.get(2654)); // Expected output: Suvadwip
        System.out.println(map.keySet());

        System.out.println(map.isEmpty());
    }
}
