import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = sc.nextInt();
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = sc.nextInt();
        }
        
        int result = 0;
        for (int i =0; i < n ;i++) {
            int remain = b;
            int cnt = 0;
            for (int j=0; j < n; j++) {
                int point = (i==j) ? p[j]/2 : p[j];
                if (remain - point >= 0) {
                    cnt++; remain -= point;
                }
                else break;
            }
            result = Math.max(result, cnt);
        }
        System.out.println(result);
    }
}