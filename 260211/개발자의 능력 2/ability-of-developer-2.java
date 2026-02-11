import java.util.Scanner;
public class Main {
    public static int[] arr = new int[6];
    static int totalSum = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 6; i++) {
            arr[i] = sc.nextInt();
            totalSum += arr[i];
        }
        
        int minDiff = Integer.MAX_VALUE;
        for (int i =0; i < 6; i++) {
            for (int j = i+1; j < 6; j++) {

                for (int k = 0; k < 6; k++)
                    for (int l = k+1; l < 6; l++) {
                        if (k == i || k == j || l == i || l == j) continue;
                        minDiff = Math.min(minDiff, diff(i, j, k, l));
                    }

            }
        }
        System.out.println(minDiff);
    }

    private static int diff(int i, int j, int k, int l) {
        int team1 = arr[i]+arr[j];
        int team2 = arr[k]+arr[l];
        int team3 = totalSum - team1-team2;

        int ret = Math.abs(team1-team2);
        ret = Math.max(ret, Math.abs(team2-team3));
        ret = Math.max(ret, Math.abs(team3-team1));
        return ret;
    }
}