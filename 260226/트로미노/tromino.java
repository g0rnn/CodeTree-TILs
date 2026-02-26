import java.util.Scanner;

public class Main {
    static int[][] offset = {
                            {1, 0, 0, 1},
                            {1, 0, -1, 0},
                            {1, 0, 0, -1},
                            {-1, 0, 1, 0},
                            {-1, 0, 0, 1},
                            {-1, 0, 0, -1},
                            {0, 1, 1, 0},
                            {0, 1, -1, 0},
                            {0, 1, 0, -1},
                            {0, -1, -1, 0},
                            {0, -1, 1, 0},
                            {0, -1, 0, 1},
                            };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        
        int max = -1;
        for (int i = 0; i < n ;i++) {
            for (int j = 0; j < m; j++) {
                for (int[] o : offset ) {
                    int nx = i + o[0];
                    int ny = j + o[1];
                    int nx2 = i + o[2];
                    int ny2 = j + o[3];

                    if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
                    if (nx2 < 0 || ny2 < 0 || nx2 >= m || ny2 >= n) continue;
                    int sum = grid[i][j] + grid[ny][nx] + grid[ny2][nx2];
                    max = Math.max(sum, max);
                }
            }
        }

        System.out.println(max);
    }
}