
// package Day79;

public class MinimumLockRotation {
    public static int minRotations(int[] lock, int[] key) {
        int maxRotations = 0;
        for (int i = 0; i < lock.length; i++) {
            // Calculate the rotations needed for each lock to match the key
            int rotations = Math.abs(lock[i] - key[i]);
            int rotations2 = 10 - key[i];

            maxRotations += Math.min(rotations, rotations2);
        }
        return maxRotations;
    }

    public static void main(String[] args) {
        int[] lock = { 1, 2, 3, 4, 5 };
        int[] key = { 5, 4, 3, 2, 1 };

        System.out.println("Minimum rotations to unlock: " + minRotations(lock, key));
    }
}
