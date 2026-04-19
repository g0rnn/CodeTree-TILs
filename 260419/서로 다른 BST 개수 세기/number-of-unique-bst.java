import java.util.*;
public class Main {
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        dp[1] = 1;
        System.out.println(dfs(n));
    }

    private static int dfs(int cur) {
        if (cur == 0) return 1;
        if (dp[cur] != -1) return dp[cur];

        int sum = 0;
        for (int i = 0; i < cur; i++) {
            sum += dfs(i) * dfs(cur-i -1);
        }
        return dp[cur] = sum;
    }
}