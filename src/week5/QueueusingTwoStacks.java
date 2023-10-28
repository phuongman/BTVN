import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner input = new Scanner(System.in);
        Queue<Integer> queue = new ArrayDeque<>();
        int q = input.nextInt();
        while (q-- != 0) {
            int type = input.nextInt();
            if (type == 1) {
                int x = input.nextInt();
                queue.add(x);
            }
            else if (type == 2) {
                queue.remove();
            }
            else {
                System.out.println(queue.peek());
            }
        }

    }
}
