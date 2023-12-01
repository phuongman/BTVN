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
     * Complete the 'connectedCell' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY matrix as parameter.
     */

    public static int[][] a = new int[15][15];
    public static int[][] xd = new int[15][15];
    public static int[] x = {-1, -1, -1, 0, 0, 1, 1, 1};
    public static int[] y = {-1, 0, 1, -1, 1, -1, 0, 1};
    public static int n;
    public static int m;
    public static int bfs(int i, int j) {
        if (xd[i][j] == 1) return 0;
        xd[i][j] = 1;
        int ma = 1;
        for (int t = 0; t < 8; t++) {
            int u = i + x[t];
            int v = j + y[t];
            if (u >= 0 && u < n && v >= 0 && v < m && a[u][v] == 1 && xd[u][v] == 0) {
                ma += bfs(u, v);
            }
        }
        return ma;
    }
    public static int connectedCell(List<List<Integer>> matrix) {
        // Write your code here
        n = matrix.size();
        for (int i = 0; i < n; i++) {
            List<Integer> b = matrix.get(i);
            m = b.size();
            for (int j = 0; j <m; j++) {
                a[i][j] = b.get(j);
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if (a[i][j] == 1 && xd[i][j] == 0) {
                    res = Math.max(res, bfs(i, j));
                }
            }
        }
        System.out.println(res);
        return res;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> matrix = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                matrix.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.connectedCell(matrix);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
