
// package Day79;
import java.util.Arrays;

public class MiceInHole {
    public static int minTime(int[] holes, int[] mice) {
        // Sort the holes and mice arrays
        Arrays.sort(holes);
        Arrays.sort(mice);
        int maxTime = 0;
        for (int i = 0; i < holes.length; i++) {
            // Calculate the time taken for each mouse to reach its hole
            maxTime = Math.max(maxTime, Math.abs(holes[i] - mice[i]));
        }
        return maxTime;
    }

    public static void main(String[] args) {
        int[] holes = { 1, 2, 3, 4, 5 };
        int[] mice = { 5, 4, 3, 6, -1 };

        System.out.println("Minimum time to get all mice in holes: " + minTime(holes, mice));
    }
}
