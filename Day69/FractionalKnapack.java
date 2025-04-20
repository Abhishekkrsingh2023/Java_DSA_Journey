import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// class that implemets comparable for comparing the objects
class Item implements Comparable<Item> {
    int w;
    int p;
    int pw;

    public Item(int w, int p, int pw) {
        this.w = w;
        this.p = p;
        this.pw = pw;
    }

    @Override
    public int compareTo(Item o) {
        return this.pw < o.pw ? 1 : -1;
    }
}

public class FractionalKnapack {
    public static double getProfit(int[] w, int[] p, int cap) {
        int n = w.length;
        List<Item> items = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            items.add(new Item(w[i], p[i], p[i] / w[i]));
        }
        // sorting in descending order
        Collections.sort(items);
        
        double maxProfit = 0;
        for (int i = 0; i < n; i++) {
            Item obj = items.get(i);
            if (cap >= obj.w) {
                maxProfit += obj.p;
                cap -= obj.w;
            } else {
                maxProfit += (double) (obj.pw * cap);
                break;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] w = { 5, 2, 3, 3, 5 };
        int[] p = { 10, 5, 6, 15, 8 };
        int cap = 12;
        System.out.println(getProfit(w, p, cap));
    }
}