import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] x = new int[N];
        int[] y = new int[N];
        

        for (int i = 0; i < N; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
            
        }
        
        int result = Integer.MAX_VALUE;
        int minx = 40_001, miny = 40_001;
        int maxx = -1, maxy = -1;
        for (int i = 0; i < N; i++) {
            minx = 40_001; miny = 40_001;
            maxx = -1; maxy = -1;
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                minx = Math.min(minx, x[j]);
                miny = Math.min(miny, y[j]);
                maxx = Math.max(maxx, x[j]);
                maxy = Math.max(maxy, y[j]);
            }
            result = Math.min(result, (maxx-minx)*(maxy-miny));
        }
        System.out.println(result);
    }
}