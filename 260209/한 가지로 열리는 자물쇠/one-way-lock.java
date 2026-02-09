import java.util.Scanner;
public class Main {
    static int a, b, c;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        a = sc.nextInt();
         b = sc.nextInt();
         c = sc.nextInt();
    
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    if (possible(i, j, k)) ans++;
                }
            }
        }
        System.out.println(ans);
    }

    private static boolean possible(int i, int j, int k) {
        if (Math.abs(a-i) <= 2) return true;
        if (Math.abs(a-j) <= 2) return true;
        if (Math.abs(a-k) <= 2) return true;
        if (Math.abs(b-i) <= 2) return true;
        if (Math.abs(b-j) <= 2) return true;
        if (Math.abs(b-k) <= 2) return true;
        if (Math.abs(c-i) <= 2) return true;
        if (Math.abs(c-j) <= 2) return true;
        if (Math.abs(c-k) <= 2) return true;
        return false;
    }
}