import java.util.Arrays;

import edu.princeton.cs.algs4.*;

public class Sum2 {
    public static void main(String[] args){
         In in = new In("D:\\Phuong\\DaiHoc\\NamHai\\CTDLGT\\LT\\algs4-data\\1Kints.txt");
         int[] a = in.readAllInts();
        
         Arrays.sort(a);
         long res = 0;
         for(int i = 0; i < a.length; i++)
         {
            int p1 = i + 1, p2 = (int) a.length - 1;
            while(p2 > p1)
            {
                if(a[p1] + a[p2] + a[i] == 0) {
                    res++;
                    p1++;
                    p2--;
                }
                else if(a[i] + a[p1] + a[p2] < 0) p1++;
                else p2--;
            }
         }
        StdOut.println(res);
    }
}
