import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] blocks = new int[n];
        for (int i = 0; i < n; i++) {
            blocks[i] = sc.nextInt();
        }
        int s1 = sc.nextInt()-1;
        int e1 = sc.nextInt();
        int s2 = sc.nextInt()-1;
        int e2 = sc.nextInt();
        
        int[] tmp = new int[n];
        int tmpIdx = 0;
        for (int i = 0; i < n; i++) {
            if (!(s1 <= i && i < e1)) tmp[tmpIdx++] = blocks[i];
        }
        blocks = tmp.clone();
        Arrays.fill(tmp, 0);

        tmpIdx = 0;
        for (int i = 0; i < n; i++) {
            if (!(s2 <= i && i < e2)) tmp[tmpIdx++] = blocks[i];
        }
        
        int cnt = 0;
        for (int i = 0 ;i < n; i++)
            if (tmp[i]!=0) cnt++;
        System.out.println(cnt);
        for (int i = 0 ;i < n; i++)
            if (tmp[i] != 0) System.out.println(tmp[i]);
    }
}