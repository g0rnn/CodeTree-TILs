import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        
        int[][] dp = new int[n][n];
        dp[0][0] = grid[0][0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;

                int prev = Integer.MAX_VALUE;
                if (i>0) prev = Math.min(dp[i-1][j], prev);
                if (j>0) prev = Math.min(dp[i][j-1], prev);
                dp[i][j] = Math.max(grid[i][j], prev);
            }
        }

        System.out.println(dp[n-1][n-1]);
    }
}