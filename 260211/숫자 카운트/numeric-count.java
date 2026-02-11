import java.util.Scanner;
public class Main {
    static int n;
    static String[] num;
    static int[] cand;
    static int[] count1;
    static int[] count2;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        num = new String[n];
        count1 = new int[n];
        count2 = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = sc.next();
            count1[i] = sc.nextInt();
            count2[i] = sc.nextInt();
        }
        
        cand = new int[3];
        int ans = 0;
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                if (i == j) continue;
                for (int k = 1; k < 10; k++) {
                    if (j == k || i == k) continue;
                    cand[0] = i;
                    cand[1] = j;
                    cand[2] = k;
                    
                    if (check()) ans++;
                }
            }
        }
        System.out.println(ans);
    }

    private static boolean check() {
        int cnt = 0;
        for (int i = 0; i < n; i++)  {
            if (checkEachNum(num[i], count1[i], count2[i])) cnt++;
        }
        return n == cnt;
    }

    private static boolean checkEachNum(String target, int ans1, int ans2) {
        int cnt1=0, cnt2=0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (target.charAt(i) == cand[j]+'0') {
                    if (i == j) cnt1++;
                    else cnt2++;
                }
            }
        }

        return cnt1 == ans1 && cnt2 == ans2;
    }
}