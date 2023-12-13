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
     * Complete the 'kruskals' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts WEIGHTED_INTEGER_GRAPH g as parameter.
     */

    /*
     * For the weighted graph, <name>:
     *
     * 1. The number of nodes is <name>Nodes.
     * 2. The number of edges is <name>Edges.
     * 3. An edge exists between <name>From[i] and <name>To[i]. The weight of the edge is <name>Weight[i].
     *
     */
    static class Edge implements Comparable<Edge> {
        private final int f, se;
        private final double weight;

        public Edge(int u, int v, double w) {
            f = u;
            se = v;
            weight = w;
        }

        public int either() {
            return f;
        }

        public int other(int ver) {
            if(ver == f) return se;
            return f;
        }

        public double getWeight() {
            return weight;
        }

        @Override
        public int compareTo(Edge other) {
            if (weight < other.getWeight()) return -1;
            if (weight > other.getWeight()) return 1;
            if (f + se + weight < other.either() + other.other(other.either()) + other.getWeight()) {
                return -1;
            } else if (f + se + weight > other.either() + other.other(other.either()) + other.getWeight()) {
                return 1;
            }
            return 0;
        }
    }

    public static int[] root = new int[3005];
    public static int result = 0;
    public static int getRoot(int u) {
        if(root[u] < 0) return u;
        return root[u] = getRoot(root[u]);
    }
    public static void join(int u, int v, double w) {
        int p = getRoot(u);
        int q = getRoot(v);
        if(p != q) {
            result += w;
            if (root[p] < root[q]) {
                root[p] += root[q];
                root[q] = p;
            } else {
                root[q] += root[p];
                root[p] = q;
            }
        }
    }

    public static int kruskals(int gNodes, List<Integer> gFrom, List<Integer> gTo, List<Integer> gWeight) {
        List<Edge> edge = new ArrayList<>();
        for (int i = 0; i < gFrom.size(); i++) {
            int u = gFrom.get(i);
            int v = gTo.get(i);
            int w = gWeight.get(i);
            edge.add(new Edge(u, v, w));
        }
        Collections.sort(edge);
        for (int i = 1; i <= gNodes; i++) root[i] = -1;
        for (int i = 0; i < edge.size(); i++) {
            int u = edge.get(i).f;
            int v = edge.get(i).se;
            double w = edge.get(i).weight;
            join(u, v, w);
        }
        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] gNodesEdges = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int gNodes = Integer.parseInt(gNodesEdges[0]);
        int gEdges = Integer.parseInt(gNodesEdges[1]);

        List<Integer> gFrom = new ArrayList<>();
        List<Integer> gTo = new ArrayList<>();
        List<Integer> gWeight = new ArrayList<>();

        IntStream.range(0, gEdges).forEach(i -> {
            try {
                String[] gFromToWeight = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                gFrom.add(Integer.parseInt(gFromToWeight[0]));
                gTo.add(Integer.parseInt(gFromToWeight[1]));
                gWeight.add(Integer.parseInt(gFromToWeight[2]));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int res = Result.kruskals(gNodes, gFrom, gTo, gWeight);
        // Write your code here.
        bufferedWriter.write(String.valueOf(res));
        bufferedReader.close();
        bufferedWriter.close();
    }
}
