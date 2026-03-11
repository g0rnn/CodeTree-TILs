import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int[] top = new int[n];
        int[] bottom = new int[n];
        for (int i = 0; i < n; i++) {
            top[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            bottom[i] = sc.nextInt();
        }
        
        while (t-- > 0) {
            int tmp = top[n-1];
            int tmp2 = bottom[n-1];
            for (int i = n-1; i > 0; i--) 
                top[i] = top[i-1];
            for (int i = n-1; i > 0; i--) 
                bottom[i] = bottom[i-1];
            bottom[0] = tmp;
            top[0] = tmp2;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) sb.append(top[i]).append(' ');
        sb.append('\n');
        for (int i = 0; i < n; i++) sb.append(bottom[i]).append(' ');
        System.out.println(sb);
    }
}