import java.util.*;

public class Main {
    static int[][] offset = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        int r = sc.nextInt()-1;
        int c = sc.nextInt()-1;
        
        bomb(grid, r, c);
        //for (int i=0; i < n; i++) System.out.println(Arrays.toString(grid[i]));
        pull(grid);
        StringBuilder sb= new StringBuilder();
        for (int i =0; i < n; i++) {
            for (int j = 0; j < n; j++)
                sb.append(grid[i][j]).append(' ');
            sb.append('\n');
        }
        System.out.println(sb);
    }

    private static void pull(int[][] grid) {
        for (int col = 0; col < n; col++) {
            int write = n-1;
            for (int row = n-1; row >= 0; row--) {
                if (grid[row][col] == 0) continue;
                grid[write][col] = grid[row][col];
                if (write != row) grid[row][col]=0;
                write--;
            }
            while (write>=0) grid[write--][col] = 0;
        }
    }

    private static void bomb(int[][] grid, int r, int c) {
        int cnt = grid[r][c];
        grid[r][c] = 0;

        for (int d = 0; d < 4; d++) {
            int range=cnt-1;
            int nx = c + offset[d][0];
            int ny = r + offset[d][1];

            while (inRange(nx, ny) && range-->0) {
                grid[ny][nx] = 0;
                nx += offset[d][0];
                ny += offset[d][1];
            }
        }
    }

    private static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }
}