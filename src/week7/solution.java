import java.io.*;
import java.util.*;

public class Solution {
    public static Scanner sc = new Scanner(System.in);
    public static int n;
    public static int[] a = new int[5006];
    //public static Random rand = new Randdom();
    
    public static void swap(int i, int j) {
        int x = a[i];
        a[i] = a[j];
        a[j] = x;
    }
    public static int partition(int l, int r, int[] a) {
        //int pos = r;
        //swap(l, pos);
        int i = l;
        for(int j = l; j < r; j++) {
            if(a[j] < a[r]) {
                swap(i, j);
                i++;
            }
        }
        swap(r, i);
        return i;
        
    }
    public static void quicksort(int l, int r, int[] a) {
        if(l >= r) {
            return;
        }
        int mid = partition(l, r, a);
        for(int i = 1; i <= n; i++) System.out.print(a[i] + " ");
        System.out.print("\n");
        quicksort(l, mid - 1, a);
        quicksort(mid + 1, r, a);
        
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        n = sc.nextInt();
        for(int i = 1; i <= n; i++) a[i] = sc.nextInt();
        quicksort(1, n, a);
        
        
        
        
    }
}
