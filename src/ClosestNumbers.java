import java.util.Arrays;
import java.util.Scanner;

public class ClosestNumbers {
    public static void main(String[] agrs) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] a = new int[n + 2];
        for(int i = 1; i <= n; i++) a[i] = input.nextInt();
        Arrays.sort(a, 1, n + 1);
        int mi = (int) 1e9;
        for(int i = 2; i <= n; i++)  mi = Math.min(mi, a[i] - a[i - 1]);
        for(int i = 2; i <= n; i++) if(a[i] - a[i - 1] == mi) System.out.print(a[i - 1] + " " + a[i] + " ");

    }   
}