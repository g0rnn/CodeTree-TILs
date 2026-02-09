import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] candies = new int[101];
        for (int i = 0; i < n; i++) {
            int cnt = sc.nextInt();
            int pos = sc.nextInt();
            candies[pos] = cnt;
        }
        
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= 100; i++) {
            int sum = 0;
            for (int j = i-k; j <= i+k; j++) {
                if (j < 1 || j > 100) continue;
                sum += candies[j];
            }
            max = Math.max(sum, max);
        }
        System.out.println(max);
    }
}