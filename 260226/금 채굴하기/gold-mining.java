import java.util.Scanner;

public class Main {
    static int[][] offset = {{1, 0}, {1, 1}, {1, -1}, {-1, 0}, {-1, 1}, {-1, -1}, {0, 1}, {0, -1}};
    static int n, m;
    static int[][] grid;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        
        int max = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum = getGold(j, i); // 채집할 수 있는 골드 최대 수
                max = Math.max(max, sum); // 정답갱신
            }
        }

        System.out.println(max);
    }

    // 알아서 다 걸러야함. 채집했을 때 이득인 것만 검사하고 리턴해야함.

    // 현재위치에서 생성할 수 있는 모든 마름로를 확인하고 검사
    private static int getGold(int x, int y) {
        int max = -1;
        for (int i = 0; i <= n/2+1; i++) {
            int cnt = rhombus(i, x, y); // 금을 몇개 캘 수 있는지
            if (i*i + (i+1)*(i+1) < cnt*m) max = Math.max(max, cnt);
        }
        return max;
    }

    // 마름로를 생성하고 검사
    private static int rhombus(int size, int x, int y) {
        if (size == 0) return grid[y][x];

        int sum = 0;
        for (int s = 1; s <= size; s++) {
            for (int[] o : offset ){
                int nx = x + o[0]*s;
                int ny = y + o[1]*s;

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if (Math.abs(nx-x)+Math.abs(ny-y) > size) continue;
                sum += grid[ny][nx];
            }
        }

        return sum + grid[y][x];
    }
}