import java.util.Arrays;
import java.util.Scanner;

public class Pairs {
    public static void main(String[] agrs) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        int[] a = new int[n + 2];
        for(int i = 1; i <= n; i++) a[i] = input.nextInt();
        Arrays.sort(a, 1, n + 1);
        int res = 0;
        int i = 1; int pos = 2;
        while(i <= n) {
            int cnt = 0; int cnt2 = 1;
            while(i < n && a[i + 1] == a[i]) {cnt2++; i++;}
            if(k == 0) res += cnt2 * (cnt2 - 1) / 2;
            else {
                pos = i + 1;
                while(pos <= n && a[pos] - a[i] < k) pos++;
                while(pos <= n && a[pos] - a[i] == k) {
                    cnt++;
                    pos++;
                }
                res += cnt * cnt2;
            }
            i++;
        }
        System.out.print(res);
    }
}
