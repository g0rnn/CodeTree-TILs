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
        
        int result = Integer.MAX_VALUE;
        for (int i = 0 ;i < n-1; i++) {
            for (int j=i+1; j < n; j++) {
                result = Math.min(result, (int)Math.pow(Math.abs(x[i]-x[j]), 2) + (int)Math.pow(Math.abs(y[i]-y[j]), 2));
            }
        }

        System.out.println(result);
    }
}