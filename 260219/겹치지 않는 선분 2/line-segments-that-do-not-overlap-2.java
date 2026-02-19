import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x1 = new int[n];
        int[] x2 = new int[n];
        for (int i = 0; i < n; i++) {
            x1[i] = sc.nextInt();
            x2[i] = sc.nextInt();
        }
        
        int cnt = 0;
        for (int i = 0; i < n; i++) {

            boolean flag = false;
            for (int j = 0; j < n; j++) {
                if (i == j) continue;

                if (cross(x1, x2, i, j)) {
                    flag=true;
                    break;
                }
            }
            if(!flag) cnt++;
        }

        System.out.println(cnt);
    }

    private static boolean cross(int[] x1, int[] x2, int i, int j) {
        if (x1[i] - x1[j] >= 0 && x2[i] - x2[j] <= 0) return true;
        if (x1[i] - x1[j] <= 0 && x2[i] - x2[j] >= 0) return true;
        return false;
    }
}