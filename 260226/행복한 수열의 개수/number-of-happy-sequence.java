import java.util.Scanner;
  
public class Main {
    static int m;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        m = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        
        // 열과 행을 한번에 계산
        // 둘중에 되는 것들만 계산!!!

        // 일단 행을 기준으로만 생각해봐
        int result = 0;
        for(int i = 0; i < n; i++) {
            // 열게산
            if (isHappyCol(grid, i)) result++;
            if (isHappyRow(grid, i)) result++;
        }
        System.out.println(result);
    }

    private static boolean isHappyRow(int[][] grid, int r) {
        int cnt = 0;
        int prev = grid[r][0];
        for (int i = 1; i < n; i++) {
            while (i < n && grid[r][i] == prev) {
                cnt++;
                i++;
            }
            if (cnt+1 >= m) return true;
            prev = grid[r][i];
            cnt =0;
        }
        if (cnt+1 >= m)return true;
        return false;
    }

    private static boolean isHappyCol(int[][] grid, int c) {
        int cnt = 0;
        int prev = grid[0][c];
        for (int i = 1; i < n; i++) {
            while (i < n && grid[i][c] == prev) {
                cnt++;
                i++;
            }
            if (cnt+1 >= m) return true;
            prev = grid[i][c];
            cnt=0;
        }
        if (cnt+1 >= m)return true;
        return false;
    }
}