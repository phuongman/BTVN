import java.util.Scanner;
import java.util.ArrayDeque;
import java.util.Deque;


public class deque {
    private static int n;
    private static int[] arr = new int[1000001];
    private static Deque<Integer> q;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 1; i <= n; i++) arr[i] = sc.nextInt();
        q = new ArrayDeque<>();
        int k = sc.nextInt();

        for(int i = 1; i <= n; i++) {
            if(i < k) {
                while(!q.isEmpty() && arr[i] >= arr[q.getLast()]) q.removeLast();
                q.addLast(i);
            }
            else {
                while(!q.isEmpty() && q.getFirst() < i - k + 1) q.removeFirst();
                while(!q.isEmpty() && arr[i] >= arr[q.getLast()]) q.removeLast();
                q.addLast(i);
                System.out.print(arr[q.getFirst()] + " ");
            }

        }
    }

}
