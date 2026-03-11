import java.util.*;
public class Main {
    static int[][] building;
    static int[][] offset = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int q = sc.nextInt();
        building = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                building[i][j] = sc.nextInt();
        int[][] queries = new int[q][4];
        for (int i = 0; i < q; i++){
            for (int j = 0; j < 4; j++) {
                queries[i][j] = sc.nextInt() - 1;
            }
            move(queries[i][0], queries[i][1], queries[i][2], queries[i][3]);
        }
            
        StringBuilder sb= new StringBuilder();
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++) {
                sb.append(building[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    private static void move(int r1, int c1, int r2, int c2) {
        //move
        int tmp = building[r1][c1];
        for (int i = r1; i <= r2-1; i++) {
            building[i][c1] = building[i+1][c1];
        }
        for (int i = c1; i <= c2-1; i++) {
            building[r2][i] = building[r2][i+1];
        }
        for (int i = r2; i >= r1+1; i--) {
            building[i][c2] = building[i-1][c2];
        }
        for (int i = c2; i >= c1+1; i--) {
            building[r1][i] = building[r1][i-1];
        }
        building[r1][c1+1] = tmp;

        //update
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
        
                    int sum = building[i][j];
                    int cnt = 1;
                    for (int d = 0; d < 4; d++) {
                        int nx = j + offset[d][0];
                        int ny = i + offset[d][1];
                        if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
                        sum += building[ny][nx];
                        cnt++;
                    }
                    q.offer(sum/cnt);
                
            }
        }

        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                
                    building[i][j] = q.poll();
                
            }
        }
    }
}