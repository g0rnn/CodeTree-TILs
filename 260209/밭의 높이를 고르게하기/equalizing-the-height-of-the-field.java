import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int h = sc.nextInt();
        int t = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        int min = Integer.MAX_VALUE;
        for (int s = 0; s <= n - t; s++) {
            for (int e = s + t-1; e < n; e++) {
                int weight = 0;
                for (int i=0; i < t; i++) {
                    weight += Math.abs(arr[s+i] - h);
                }
                min = Math.min(min, weight);
            }
        }
        System.out.println(min);
    }
}