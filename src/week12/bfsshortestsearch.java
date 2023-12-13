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
     * Complete the 'bfs' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER m
     *  3. 2D_INTEGER_ARRAY edges
     *  4. INTEGER s
     */

    public static List<Integer> bfs(int n, int m, List<List<Integer>> edges, int s) {
        // Write your code here
        int[] l = new int[n + 1];
        for(int i = 1; i <= n; i++) l[i] = n + 1;
        l[s] = 0;
        List<List<Integer>> e = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            List<Integer> c = new ArrayList<>();
            e.add(c);
        }
        for (int i = 0; i < m; i++) {
            int u = edges.get(i).get(0);
            int v = edges.get(i).get(1);
            e.get(u).add(v);
            e.get(v).add(u);


        }
        int cnt = 0;
        List<Integer> q = new ArrayList<>();
        q.add(s);
        while (cnt < q.size()) {
            int u = q.get(cnt++);
            List<Integer> si = e.get(u);
            for (int i = 0; i < si.size(); i++) {
                int v = si.get(i);
                if(l[v] > l[u] + 1) {
                    l[v] = l[u] + 1;
                    q.add(v);
                }
            }
        }

        List <Integer> res = new ArrayList();
        for (int i = 1; i <= n; i++) {
            if (i == s) continue;
            if (l[i] == n + 1) res.add(-1);
            else res.add(l[i] * 6);
        }
        return res;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
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

                int s = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> result = Result.bfs(n, m, edges, s);

                bufferedWriter.write(
                        result.stream()
                                .map(Object::toString)
                                .collect(joining(" "))
                                + "\n"
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
