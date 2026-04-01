import java.util.*;
public class Main {
    static int n, x, y;
    static char[][] grid;
    static int[][] offset = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}}; // 우 상 좌 하

    static class Node {
        int x, y, dir;
        Node(int x, int y, int dir) {
            this.x=x;this.y=y;this.dir=dir;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        y = sc.nextInt()-1;
        x = sc.nextInt()-1;
        sc.nextLine();
        grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();    // 한 줄 입력
            grid[i] = line.toCharArray();   // char 배열로 변환
        }
        
        // 오른쪽을 보고 있어야함.
        // 오른쪽에 벽이 없어지면 오른쪽을 본다.
        // 벽이 안보일 때까지 왼쪽으로 돈다.
        // 이동한다.
        // visited = true인 곳으로 이동하면 -1 반환

        int ret = escape(x, y);
        System.out.println(ret > 0 ? ret : -1);
    }

    private static int escape(int x, int y) {
        boolean[][][] visited = new boolean[n][n][4];
        Node node = new Node(x, y, 0);
        int t = 0;
        while (inRange(node.x, node.y)) {
            if (visited[node.y][node.x][node.dir]) return -1;
            visited[node.y][node.x][node.dir] = true;
            if (!move(node)) return -1; // 움직일 수 없을 때

            ++t;
        }
        return t;
    }

    private static boolean inRange(int x, int y) {
        return 0 <= x && 0 <= y && x < n && y < n;
    }

    private static boolean move(Node node) {
        int rightDir = (node.dir + 3) % 4;
        int rx = node.x + offset[rightDir][0];
        int ry = node.y + offset[rightDir][1];

        if (!inRange(rx, ry) || grid[ry][rx] == '.') {
            node.dir = rightDir; // 방향을 오른쪽으로 틀고
            node.x = rx;         // 한 칸 전진
            node.y = ry;
            return true;
        }

        // 2. 오른쪽이 벽이라면, 갈 수 있는 방향이 나올 때까지 왼쪽으로 회전
        // 최대 4번 확인 (자기 자리로 돌아오면 갇힌 것)
        for (int i = 0; i < 4; i++) {
            int nextDir = (node.dir + i) % 4; // 현재 -> 왼쪽 -> 뒤 -> 오른쪽 순서
            int nx = node.x + offset[nextDir][0];
            int ny = node.y + offset[nextDir][1];

            if (!inRange(nx, ny) || grid[ny][nx] == '.') {
                node.dir = nextDir;
                node.x = nx;
                node.y = ny;
                return true;
            }
        }

        return false;
    }
}