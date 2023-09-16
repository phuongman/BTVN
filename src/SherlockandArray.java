import java.util.Scanner;

public class SherlockandArray {
    
    public static void main(String[] agrs) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        int n;
        int[] a, sum;
        while(T-- != 0) {
            n = input.nextInt();
            a = new int[n + 1];
            for(int i = 1; i <= n; i++) a[i] = input.nextInt();
            sum = new int[n + 2];
            sum[n + 1] = 0;
            for(int i = 1; i <= n; i++) sum[i] = sum[i - 1] + a[i];
            int sum2 = 0;
            boolean ok = false;
            for(int i = n; i >= 1; i--) {
                if(sum[i - 1] == sum2) {ok = true; break;}
                sum2 += a[i];
            }
            if(ok == true) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
