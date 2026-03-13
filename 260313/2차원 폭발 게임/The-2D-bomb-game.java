import java.util.*;

public class Main {
    static int n, m, k;
    static int[][] grid;
    static int[][] offset = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt()+1;
        grid = new int[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        
        while (k-- > 0) {
            bomb(m);
            //for(int i =0; i < n; i++) System.out.println(Arrays.toString(grid[i]));
            //System.out.println();
            pull();
            //for(int i =0; i < n; i++) System.out.println(Arrays.toString(grid[i]));
            //System.out.println();
            rotate();
            //for(int i =0; i < n; i++) System.out.println(Arrays.toString(grid[i]));
            //System.out.println();
            pull();
            //for(int i =0; i < n; i++) System.out.println(Arrays.toString(grid[i]));
            //System.out.println();
        }        

        System.out.println(count());
    }

    private static void bomb(int m) {
        for (int c = 0; c < n; c++) {
            for (int r = 0; r < n-1; r++) {
                if (grid[r][c] == grid[r+1][c]) {
                    int cnt = 0;
                    int prev = r;
                    while (r < n && grid[r][c] == grid[prev][c]) {cnt++; r++;}
                    if (cnt >= m)
                        for (int i = prev; i < r; i++) grid[i][c] = 0;
                    r--;
                }
            }
            
            /*
            int prev = r; 
                    while (++r < n && grid[r][c] == grid[prev][c]) {
                        grid[r][c] = 0;
                    }
                    grid[prev][c]=0;
                    r--;
            */
        }
    }

    private static void pull() {
        for (int col = 0; col < n; col++) {
            int write = n-1; // 이거 맨날 틀리노;
            for (int row = n-1; row >= 0; row--) {
                if (grid[row][col] == 0) continue;
                grid[write][col] = grid[row][col];
                if (write != row) grid[row][col] = 0;
                write--;
            }
            while (write >= 0) grid[write--][col] = 0;
        }
    }

    private static void rotate() {
        int[][] gridNew = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                gridNew[i][j] = grid[n - j - 1][i];
            }
        }
        grid = gridNew;
    }

    private static int count() {
        int cnt = 0;
        for (int i = 0 ;i < n; i++)
            for (int j = 0; j < n; j++)
                if (grid[i][j] != 0) cnt++;
        return cnt;
    }
}