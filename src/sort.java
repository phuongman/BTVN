import java.util.Scanner;

public class sort {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] a = new int[n + 5];
        for (int i = 1; i <= n; i++) a[i] = input.nextInt();
        for (int i = 1; i <= n; i++) {
            int mi = a[i], pos = i;
            for (int j = i; j <= n; j++) {
                mi = Math.min(mi, a[j]);
                if(mi == a[j]) pos = j;
            }
            a[pos] = a[i];
            a[i] = mi;
        }
        for(int i = 1; i <= n; i++) System.out.print(a[i] + " ");
    }
}
