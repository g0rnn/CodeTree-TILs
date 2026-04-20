import java.util.*;

public class Main {
    static final int MAX_N = 105;
    static final int INF = Integer.MAX_VALUE;
    static int[][] grid = new int[MAX_N][MAX_N];
    static int[][] dp = new int[MAX_N][MAX_N];
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        TreeSet<Integer> nums = new TreeSet<>();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                grid[i][j] = sc.nextInt();
                nums.add(grid[i][j]);
            }
        }

        int ans = INF;

        // 각 숫자를 최솟값(low)으로 가정하고 반복
        for (int low : nums) {
            // dp 테이블 초기화
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    dp[i][j] = INF;
                }
            }

            // 시작점 예외 처리 (시작점이 설정한 low보다 작으면 불가능)
            if (grid[1][1] < low) continue;
            dp[1][1] = grid[1][1];

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (i == 1 && j == 1) continue;
                    if (grid[i][j] < low) continue; // low보다 작으면 이동 불가

                    int prevMin = INF;
                    if (i > 1) prevMin = Math.min(prevMin, dp[i - 1][j]);
                    if (j > 1) prevMin = Math.min(prevMin, dp[i][j - 1]);

                    if (prevMin != INF) {
                        dp[i][j] = Math.max(grid[i][j], prevMin);
                    }
                }
            }

            // 목적지에 도달 가능한 경우 차이 계산
            if (dp[n][n] != INF) {
                ans = Math.min(ans, dp[n][n] - low);
            }
        }

        System.out.println(ans);
    }
}