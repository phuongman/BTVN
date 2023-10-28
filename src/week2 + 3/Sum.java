import java.util.*;
import edu.princeton.cs.algs4.*;


public class Sum {
    public static void main(String[] arg) {
        In in = new In("D:\\Phuong\\DaiHoc\\NamHai\\CTDLGT\\LT\\algs4-data\\8Kints.txt");
        int[] a = in.readAllInts();
        Arrays.sort(a);

        long res = 0;
        int p1 = 0, p2 = (int) a.length - 1;
        while(p2 > p1)
        {
            if(a[p1] + a[p2] == 0){
                 res++;
                 p1++;
                 p2--;
            }
            else if(a[p1] + a[p2] < 0) p1++;
            else p2--;
        }

        StdOut.println(res);

    }
}

