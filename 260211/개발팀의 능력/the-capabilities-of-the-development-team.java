import java.util.Scanner;
public class Main {
    static int[] dev = new int[5];
    static int total = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            dev[i] = sc.nextInt();
            total += dev[i];
        }
        
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < 5; i++) { // 1명

            for (int j = 0; j < 5; j++) {
                for (int k = j+1; k < 5; k++) {
                    if (i == j || i == k) continue;
                    minDiff = Math.min(minDiff, diff(i, j, k));
                }
            }
        }
        System.out.println(minDiff);
    }

    private static int diff(int i, int j, int k) {
        int t1 = dev[i];
        int t2 = dev[j] + dev[k];
        int t3 = total - t1-t2;

        if (t1 == t2 || t2 == t3 || t3 == t1) return Integer.MAX_VALUE;

        int d = Math.abs(t1-t2);
        d = Math.max(d, Math.abs(t2-t3));
        d = Math.max(d, Math.abs(t3-t1));
        return d;
    }
}