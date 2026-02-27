import java.util.Scanner;
public class Main {
    static int n;
    static int[][] grid;
    static int[][] offset = {{1, -1}, {-1, -1}, {-1, 1}, {1, 1}};
    static int max = -1;

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
                int sum = 0;
                for (int len1 = 1; len1 < n; len1++) {
                    for (int len2 = 1; len2 < n; len2++) {
                        sum = Math.max(sum, calc(j, i, len1, len2));
                    }
                }
                max = Math.max(max, sum);
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

    private static int calc(int x, int y, int len1, int len2) {
        int sum = 0;
        int nx = x, ny = y;

        for (int i = 1; i < len1; i++) {
            nx += offset[0][0];
            ny += offset[0][1];
            if (!inRange(nx, ny)) return -1;
            sum += grid[ny][nx];
        }

        for (int i = 1; i < len2; i++) {
            nx += offset[1][0];
            ny += offset[1][1];
            if (!inRange(nx, ny)) return -1;
            sum += grid[ny][nx];
        }

        for (int i = 1; i < len1; i++) {
            nx += offset[2][0];
            ny += offset[2][1];
            if (!inRange(nx, ny)) return -1;
            sum += grid[ny][nx];
        }

        for (int i = 1; i < len2; i++) {
            nx += offset[3][0];
            ny += offset[3][1];
            if (!inRange(nx, ny)) return -1;
            sum += grid[ny][nx];
        }

        return sum;
    }
    
    // // limit1: 1, 3, lmit2: 0, 2 dir의 제한
    // private static void recursion(int x, int y, int dir, int limit1, int limit2, int sum) {
    //     if (dir == 4) {
    //         max = Math.max(sum, max);
    //         return;
    //     }
    //     if (!inRange(x, y)) return;

    //     if (dir % 2 == 0)
    //         for (int i = 1; i < limit2; i++) {
    //             nx += offset[dir][0];
    //             ny += offset[dir][1];

    //         }

    // }

    private static boolean inRange(int nx, int ny) {
        return 0 <= nx && nx < n && 0 <= ny && ny < n;
    }
}