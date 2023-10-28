import java.io.*;
import java.util.*;

public class Solution {

    private String s;
    private Stack<String> stack = new Stack<String>();

    Solution() {
        s = "";
        stack.push(s);
    }
    public String getS() {
        return s;
    }
    public void append(String w) {
        for(int i = 0; i < w.length(); i++) if(w.charAt(i) != ' ') s += w.charAt(i);
        stack.push(s);
        return;
    }

    public void delete(int k) {
        s = s.substring(0, s.length() - k);
        stack.push(s);
        return;
    }

    public char print(int k) {
        return s.charAt(k - 1);
    }

    public void undo() {
        stack.pop();
        s = stack.peek();
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        Solution res = new Solution();
        while (q-- != 0) {
            int type = sc.nextInt();
            if (type == 1) {
                String w = sc.nextLine();
                res.append(w);
            }
            else if (type == 2) {
                int k = sc.nextInt();
                res.delete(k);

            } else if (type == 3) {
                int k = sc.nextInt();
                System.out.println(res.print(k));

            } else {
                res.undo();
            }
        }

    }
}
