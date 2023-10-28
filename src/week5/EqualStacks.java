import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'equalStacks' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY h1
     *  2. INTEGER_ARRAY h2
     *  3. INTEGER_ARRAY h3
     */

    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        // Write your code here
        Stack<Integer> n = new Stack<Integer>();
        Stack<Integer> m = new Stack<Integer>();
        Stack<Integer> p = new Stack<Integer>();
        while(h1.isEmpty() == false) {
            n.push(h1.get(0));
            h1.remove(0);
        }
        while(h2.isEmpty() == false) {
            m.push(h2.get(0));
            h2.remove(0);
        }
        while(h3.isEmpty() == false) {
            p.push(h3.get(0));
            h3.remove(0);
        }
        int sum = 0;
        int sum2 = 0;
        int sum3 = 0;
        int res = 0;
        while(!n.isEmpty() && !m.isEmpty() && !p.isEmpty()) {
            if(sum == sum2 && sum2 == sum3) {
                if(!n.isEmpty()) {
                    sum += n.peek();
                    n.pop();
                }
                else if(!m.isEmpty()) {
                    sum2 += m.peek();
                    m.pop();
                }
                else if(!p.isEmpty()) {
                    sum3 += p.peek();
                    p.pop();
                }
            }
            else {
                int ma = Math.max(sum, Math.max(sum2, sum3));
                while(!n.isEmpty() && sum < ma) {
                    sum += n.peek();
                    n.pop();
                }
                while(!m.isEmpty() && sum2 < ma) {
                    sum2 += m.peek();
                    m.pop();
                }
                while(!p.isEmpty() && sum3 < ma) {
                    sum3 += p.peek();
                    p.pop();
                }
                if(sum == sum2 && sum2 == sum3) res = Math.max(res, sum);
            }
        }
        int ma = Math.max(sum, Math.max(sum2, sum3));
        while(!n.isEmpty() && sum < ma) {
            sum += n.peek();
            n.pop();
        }
        while(!m.isEmpty() && sum2 < ma) {
            sum2 += m.peek();
            m.pop();
        }
        while(!p.isEmpty() && sum3 < ma) {
            sum3 += p.peek();
            p.pop();
        }
        if(sum == sum2 && sum2 == sum3) res = Math.max(res, sum);
        return res;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n1 = Integer.parseInt(firstMultipleInput[0]);

        int n2 = Integer.parseInt(firstMultipleInput[1]);

        int n3 = Integer.parseInt(firstMultipleInput[2]);

        List<Integer> h1 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> h2 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> h3 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.equalStacks(h1, h2, h3);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
