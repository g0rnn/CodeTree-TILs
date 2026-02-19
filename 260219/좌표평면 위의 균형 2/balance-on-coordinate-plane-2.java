import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }
        
        int result = 10_000_000;
        for (int i = 0; i < n; i++) {
            for (int j = 0 ;j < n; j++) {
                int linex = x[i] + 1;
                int liney = y[i] + 1;

                int[] q = new int[4];
                for (int k=0; k < n; k++) {
                    if (x[k] < linex && y[k] > liney) q[0]++;
                    else if (x[k] < linex && y[k] < liney) q[1]++;
                    else if (x[k] > linex && y[k] < liney) q[2]++;
                    else q[3]++;
                }

                int max = q[0];
                for (int k=1;k<4;k++) max=Math.max(max, q[k]);
                result = Math.min(result, max);
            }
        }
        System.out.println(result);
    }
}