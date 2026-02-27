import java.util.Scanner;
public class Main {
    static int n;
    static int[][] grid;
    static int[][] offset = {{1, -1}, {-1, -1}, {-1, 1}, {1, 1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        
        int max = -1;
        for (int i = n-1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dist(j, i));
            }
        }
        System.out.println(max);
    }

    private static int dist(int x, int y) {
        int moved = 0;
        int nx = x;
        int ny = y;
        int sum = 0;

        for (int d = 0; d < 4; d++) {
            while (true) {
                nx += offset[d][0];
                ny += offset[d][1];
                if (!inRange(nx, ny)) break;
                
                sum += grid[ny][nx];
                moved++;
                //System.out.println("("+nx+", "+ny+")");
            }
            nx -= offset[d][0];
            ny -= offset[d][1];
            if (moved < 1) return 0;
            else moved = 0;
        }

        return sum;
    }

    private static boolean inRange(int nx, int ny) {
        return 0 <= nx && nx < n && 0 <= ny && ny < n;
    }
}