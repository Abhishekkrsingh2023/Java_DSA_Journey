public class TwoDimensionArray {
    public static void main(String[] args) {
        // Declare a 2D array with 3 rows and 4 columns
        int[][] array = new int[3][4];

        // Initialize the 2D array
        int value = 1;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = i*j; // just adding i*j as the element
            }
        }

        // Traversing
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}