import edu.princeton.cs.algs4.*;
public class UFClient { 
   public static void main(String[] args) { 
      int N = StdIn.readInt(); 
      UF uf = new UF(N); 
      int cnt = N;
      while (!StdIn.isEmpty()) { 
         int p = StdIn.readInt(); 
         int q = StdIn.readInt(); 
         if (!uf.connected(p, q)) { 
            cnt--;
            StdOut.println(cnt);
            uf.union(p, q); StdOut.println(p + " " + q); 
         } 
      } 
   }
}