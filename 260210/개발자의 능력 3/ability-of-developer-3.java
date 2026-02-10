import java.util.Scanner;

public class Main {
    static int sum;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] ability = new int[6];
        sum = 0;
        for (int i = 0; i < 6; i++) {
            ability[i] = sc.nextInt();
            sum += ability[i];
        }
        
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) 
            for (int j = i+1; j < 5; j++)
                for (int k = j+1; k < 6; k++)
                    minDiff = Math.min(minDiff, getDiff(i, j, k, ability));
        System.out.println(minDiff);
    }

    private static int getDiff(int i, int j, int k, int[] ability) {
        int one = ability[i]+ability[j]+ability[k];
        int two = sum - one;
        return Math.abs(one - two);
    }
}