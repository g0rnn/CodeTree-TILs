import java.util.Scanner;

public class Main {
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] comb = new int[3];
        int[] comb2 = new int[3];
        comb[0] = sc.nextInt();
        comb[1] = sc.nextInt();
        comb[2] = sc.nextInt();
        comb2[0] = sc.nextInt();
        comb2[1] = sc.nextInt();
        comb2[2] = sc.nextInt();
        
        int ans = 0;
        for (int i = 1; i < n; i++) 
            for (int j = 1; j < n; j++) 
                for (int k = 1; k < n; k++) 
                    if (isPossible(comb, i, j, k) || isPossible(comb2, i, j, k)) ans++;
        System.out.println(ans);
    }

    private static boolean isPossible(int[] comb, int a, int b, int c) {
        int diff = Math.abs(comb[0]-a);
        int diff = Math.abs(comb[0]-a);
        if (Math.min(diff, n-diff) <= 2) 
        if (Math.abs(comb[1]-b) <= 2 || comb[1]-b+n <= 2) 
        if (Math.abs(comb[2]-c) <= 2 || comb[2]-c+n <= 2) return true;
        return false;
    }
}