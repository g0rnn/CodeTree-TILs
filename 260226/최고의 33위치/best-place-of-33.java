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
        
        int max = -1;
        for (int i = 0; i<= n-3; i++) {
            for (int j = 0 ;j <= n-3; j++) {

                int sum =0;
                for (int a = 0; a < 3; a++) {
                    for (int b=  0; b < 3; b++) {
                        sum += grid[i+a][j+b];
                    }
                }

                max = Math.max(sum, max);
            }
        }

        System.out.println(max);
    }
}