import edu.princeton.cs.algs4.*;
import java.util.Arrays;

class BinarySearch {

    public static int binarySeach(int[] a, int key) 
    {
        int l = 0, r = a.length - 1;
        while(l <= r) 
        {
            int mid = (l + r) >> 1;
            if(a[mid] >= key) r = mid - 1;
            else l = mid + 1;
        }
        if(l == a.length || a[l] == key) return l;
        return -1;
    }
    public static void main(String [] args) {
        In in = new In("D:\\Phuong\\DaiHoc\\NamHai\\CTDLGT\\LT\\algs4-data\\tinyW.txt");
        int [] a = in.readAllInts();

        Arrays.sort(a);
        int key = StdIn.readInt();

        StdOut.println(BinarySearch.binarySeach(a, key));
    }
}