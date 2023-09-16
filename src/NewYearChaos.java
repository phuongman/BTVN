import java.util.Scanner;

public class NewYearChaos {
    static int t;
    static int n;
    public static int[] a = new int[100005];
    

    public static void main(String[] args) {
        Scanner input  = new Scanner(System.in);
        t = input.nextInt();
        while (t-- != 0) {
            n = input.nextInt();
            for( int i = 1; i <= n; i++) a[i] = input.nextInt();
            int res = 0;
            boolean ok = true;
            for( int i = n; i >= 1; i--) {
                if(a[i] == i) continue;
                if(i - 1 > 0 && a[i - 1] == i) 
                {
                    int x = a[i];
                    a[i] = a[i - 1];
                    a[i - 1] = x;
                    res++;
                }
                else if(i - 2 > 0 && a[i - 2] == i) 
                {
                    int x = a[i];
                    a[i] = a[i - 2];
                    a[i - 2] = a[i - 1];
                    a[i - 1] = x;

                    res += 2;
                }
                else 
                {
                    ok = false;
                    break;
                }
            }
            if(ok != true) System.out.println("Too chaotic");
            else System.out.println(res);


        }
    }
} 
