import java.util.*;

// 직사각형의 왼쪽 상단과 오른쪽 하단을 선택한다고 하자.
// 직사각형의 합을 구할 때는 누적합 사용


public class Main {
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
        
        int[][] sum = new int[n][m];
        
        for (int i = 0; i < n; i++) sum[i][0] = grid[i][0];
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m; j++) {
                sum[i][j] = sum[i][j-1] + grid[i][j];
            }
        }

        for (int j = 0; j < m ;j++) {
            for (int i = 1; i < n; i++) {
                sum[i][j] = sum[i-1][j] + sum[i][j];
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = i; k < n; k++) {
                    for (int l = j; l < m; l++) {
                        int s1 = rectSum(sum, i, j, k, l);

                        for (int a = 0; a < n; a++) {
                            for (int b = 0; b < m; b++) {
                                for (int c = a; c < n; c++) {
                                    for (int d = b; d < m; d++) {
                                        // 조건 검사
                                        boolean disjoint = (l < b) || (d < j) || (k < a) || (c < i);
                                        if (!disjoint) continue;

                                        int s2 = rectSum(sum, a, b, c, d);
                                        max = Math.max(max, s1 + s2);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println(max);
    }

    // sum[r][c] = (0,0) ~ (r,c) 누적합 (0-based, inclusive)
    static int rectSum(int[][] sum, int r1, int c1, int r2, int c2) {
        int res = sum[r2][c2];
        if (r1 > 0) res -= sum[r1 - 1][c2];
        if (c1 > 0) res -= sum[r2][c1 - 1];
        if (r1 > 0 && c1 > 0) res += sum[r1 - 1][c1 - 1];
        return res;
    }
}