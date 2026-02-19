import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<int[]> points = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            points.add(new int[]{x, y});
        }
        
        if (dfs(points, 0)) System.out.println(1);
        else System.out.println(0);
    }

    private static boolean dfs(List<int[]> points, int line) {
        if (points.isEmpty()) return true;
        if (line == 3) return true;

        int[] cur = points.get(0);
        List<int[]> remaining = new ArrayList<>();
        for (int[] other : points) 
            if (cur[0] != other[0])
                remaining.add(other);
        
        if (dfs(remaining, line+1)) return true;

        remaining = new ArrayList<>();
        for (int[] other : points) 
            if (cur[1] != other[1])
                remaining.add(other);
        
        if (dfs(remaining, line+1)) return true;

        return false;
    }
}