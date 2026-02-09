import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<int[]> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int pos = sc.nextInt();
            int ch = sc.next().charAt(0);
            arr.add(new int[]{pos, ch});
        }
        arr.sort((a, b)->Integer.compare(a[0], b[0]));

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i;j < n; j++) {
                int g = 0, h = 0;
                for (int k = i; k <= j; k++) {
                    if (arr.get(k)[1] == 'G') g++;
                    else if (arr.get(k)[1] == 'H') h++;
                }
                if (g == h || g*h == 0) max = Math.max(max, arr.get(j)[0]-arr.get(i)[0]);
            }
        }
        System.out.println(max);
    }
}
