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
     * Complete the 'shortestReach' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY edges
     *  3. INTEGER s
     */
    public static int[] xd = new int[3005];
    public static ArrayList<HashMap<Integer, Integer>> adj;

    static class MinCost implements Comparable<MinCost> {
        public int ts, ver;
        public MinCost (int u, int cnt) {
            ver = u;
            ts = cnt;
        }

        @Override
        public int compareTo(MinCost c) {
            if (ts < c.ts) return -1;
            if (ts > c.ts) return 1;
            return 0;

        }
    }



    public static List<Integer> shortestReach(int n, List<List<Integer>> edges, int s) {
        // Write your code here
        for(int i = 1; i <= n; i++) xd[i] = 0;
        int[] l = new int[n + 1];
        for (int i = 1; i <= n; i++) l[i] = 1000000000;
        l[s] = 0;

        adj = new ArrayList<HashMap<Integer, Integer>>();
        for (int i = 1; i <= n + 1; i++) adj.add(new HashMap<>());
        for (List<Integer> e : edges) {
            int u = e.get(0);
            int v = e.get(1);
            int c = e.get(2);
            if (!adj.get(u).containsKey(v) || adj.get(u).get(v) > c) {
                adj.get(u).put(v, c);
            }
            if (!adj.get(v).containsKey(u) || adj.get(v).get(u) > c) {
                adj.get(v).put(u, c);
            }
        }
        for (int i = 1; i <= n; i++) System.out.println(adj.get(i).size());

        PriorityQueue<MinCost> q = new PriorityQueue<>();
        q.add(new MinCost(s, l[s]));
        while (!q.isEmpty()) {
            MinCost p = q.poll();
            if (xd[p.ver] != 0) continue;
            int u = p.ver;
            int tg = p.ts;
            xd[u] = 1;
            HashMap<Integer, Integer> e = adj.get(u);
            for (Integer v : e.keySet()) {
                int tg2 = e.get(v);
                if(l[v] > tg + tg2) {
                    l[v] = tg + tg2;
                    q.add(new MinCost(v, tg + tg2));
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        for(int i = 1; i <= n; i++) if (i != s) res.add((l[i] == 1000000000) ? -1 : l[i]);
        return res;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
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

                List<Integer> result = Result.shortestReach(n, edges, s);

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
