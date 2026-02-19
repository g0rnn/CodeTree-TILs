import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x1 = new int[n];
        int[] x2 = new int[n];
        for (int i = 0; i < n; i++) {
            x1[i] = sc.nextInt();
            x2[i] = sc.nextInt();
        }
        
        int cnt = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (i == j || visited[j]) continue;

                if (cross(x1, x2, i, j)) {
                    visited[j] = true;
                    cnt++;
                }
            }
            visited[i] = true;
        }

        System.out.println(cnt+1);
    }

    private static boolean cross(int[] x1, int[] x2, int i, int j) {
        if (x1[i] - x1[j] >= 0 && x2[i] - x2[j] <= 0) return true;
        if (x1[i] - x1[j] <= 0 && x2[i] - x2[j] >= 0) return true;
        return false;
    }
}