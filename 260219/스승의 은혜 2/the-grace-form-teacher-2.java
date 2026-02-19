import java.util.*;
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
            int[] tmp = new int[1000];
            for (int j = 0; j < n; j++) tmp[j] = p[j];
            tmp[i] /= 2;

            Arrays.sort(tmp, 0, n);

            int stu =0, money =0;
            for (int j=0; j< n; j++) {
                if (money + tmp[j] > b) break;
                money += tmp[j];
                stu++;
            }
            result = Math.max(result, stu);
        }
        System.out.println(result);
    }
}