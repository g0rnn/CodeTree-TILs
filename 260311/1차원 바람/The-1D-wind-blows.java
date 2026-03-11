import java.util.Scanner;

public class Main {
    static int n, m;
    static int[][] a;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int q = sc.nextInt();
        a = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                a[i][j] = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int r = sc.nextInt()-1;
            char d = sc.next().charAt(0);

            int dir = (d == 'L') ? 0 : 1; // 0: 왼쪽, 1: 오른쪽
            boolean[] visited = new boolean[n];
            move(r, dir, visited);
        }
        StringBuilder sb= new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(a[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void move(int row, int dir, boolean[] visited) {
        if (row < 0 || row >= n) return;
        if (visited[row]) return;

        visited[row] = true;
        // 실제로 움직이는 곳
        if (dir == 0) moveLeft(row);
        else moveRight(row);

        if (row > 0 && !visited[row-1]) {
            for (int i = 0; i < m; i++) {
            if (a[row][i] == a[row-1][i]) {
                move(row-1, 1-dir, visited);
                break;
            }
        }
        }
        
        if (row < n-1 && !visited[row+1]) {
            for (int i = 0; i < m; i++) {
            if (a[row][i] == a[row+1][i]) {
                move(row+1, 1-dir, visited);
                break;
            }
        }
        }
    }

    private static void moveLeft(int row) {
        int tmp = a[row][m-1];
        for (int i = m-1; i >= 1; i--) a[row][i] = a[row][i-1];
        a[row][0] = tmp;
    }

    private static void moveRight(int row) {
        int tmp = a[row][0];
        for (int i = 0; i <= m-2; i++) a[row][i] = a[row][i+1];
        a[row][m-1] = tmp;
    }
}