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
     * Complete the 'prims' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY edges
     *  3. INTEGER start
     */
    public static int[] xd = new int[3005];
    static class Cost implements Comparable<Cost> {
        public int r, v;
        public Cost(int cost, int vertex) {
            r = cost;
            v = vertex;
        }
        @Override
        public int compareTo(Cost c) {
            if (r < c.r) return -1;
            if (r> c.r) return 1;
            if (v < c.v) return -1;
            if (v > c.v) return 1;
            return 0;
        }

    }

    public static boolean check(Cost p) {
        if(xd[p.v] != 0) return false;
        return true;
    }
    public static int prims(int n, List<List<Integer>> edges, int start) {
        // Write your code here
        for(int i = 1; i <= n; i++) xd[i] = 0;
        PriorityQueue<Cost> q = new PriorityQueue<>();
        List<List<Cost>> a = new ArrayList<>();
        for(int i = 1; i <= n + 1; i++) {
            a.add(new ArrayList<Cost>());
        }
        for (List<Integer> e : edges) {
            int u = e.get(0);
            int v = e.get(1);
            int c = e.get(2);
            a.get(u).add(new Cost(c, v));
            a.get(v).add(new Cost(c, u));
        }
        int dem = 0;
        int sum = 0;
        while (dem < n - 1) {
            xd[start] = 1;
            for (Cost e : a.get(start)) {
                q.add(e);
            }
            while (!q.isEmpty() && !check(q.peek())) q.remove();
            Cost top = q.peek();
            q.remove();
            sum += top.r;
            start = top.v;
            dem++;
        }
        return sum;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> edges = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                edges.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int start = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.prims(n, edges, start);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
