public class FloydWarshallAlgo {
    public static void getDistance(int[][] mat) {
        int v = mat.length;
        for (int i = 0; i < v; i++)
            for (int j = 0; j < v; j++)
                if (mat[i][j] == -1)
                    mat[i][j] = Integer.MAX_VALUE; // denotes infinity
        // the main algo
        for (int k = 0; k < v; k++)
            for (int i = 0; i < v; i++)
                for (int j = 0; j < v; j++) {
                    if (mat[i][k] == Integer.MAX_VALUE || mat[k][j] == Integer.MAX_VALUE)
                        continue;
                    mat[i][j] = Math.min(mat[i][j], mat[i][k] + mat[k][j]);
                }
        // negative cycle detection
        for (int i = 0; i < v; i++) {
            if (mat[i][i] < 0) {
                System.out.println("Negative weight cycle");
                break;
            }
        }
    }

    public static void main(String[] args) {
        int v = 4;
        // -1 denotes no edge
        int[][] mat = {
                {0, 2, -1, 8},
                {-1, 0, 1, 4},
                {-1, -1, 0, 2},
                {-1, -1, -1, 0}
        };
        getDistance(mat);
        for (int[] row : mat) {
            for (int ele : row) {
                if (ele == Integer.MAX_VALUE)
                    System.out.print(-1 + " ");
                else
                    System.out.print(ele + " ");
            }
            System.out.println();
        }
    }
}
