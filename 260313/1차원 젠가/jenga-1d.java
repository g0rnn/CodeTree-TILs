import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] blocks = new int[n];
        for (int i = 0; i < n; i++) {
            blocks[i] = sc.nextInt();
        }
        
        for(int k = 0; k < 2; k++) {
            int s = sc.nextInt()-1; // inclusive
            int e = sc.nextInt();   // exclusive
            pull(blocks, s, e);
            //System.out.println(Arrays.toString(blocks));
        }

        StringBuilder sb= new StringBuilder();
        int cnt = 0;
        for (int i = 0; i < n; i++) 
            if (blocks[i] != 0) {
                sb.append(blocks[i]).append('\n');
                cnt++;
            }
        System.out.println(cnt);
        System.out.println(sb);
    }

    private static void pull(int[] blocks, int s, int e) {
        int write = 0;
        for (int i = 0; i < blocks.length; i++) {
            if (s <= i && i < e) continue;
            blocks[write] = blocks[i];
            if (write != i) blocks[i] = 0;
            write++;
        }
        while (write < blocks.length) {
            blocks[write++] = 0;
        }
    }
}