import edu.princeton.cs.algs4.*;

public class UFClient2 {
    public static void main(String[] args) { 
      In in = new In("D:\\Phuong\\DaiHoc\\NamHai\\CTDLGT\\LT\\algs4-data\\tinyUF.txt");
      StdOut.println(in.exists());
      int N = in.readInt();
      StdOut.println(N);
      UF uf = new UF(N); 
      int cnt = N, res  = 0;      
      while(!in.isEmpty()) 
      {
        int p = in.readInt();
        int q = in.readInt();
        StdOut.println(p + " " + q);
        if (!uf.connected(p, q))
        {
            cnt--;
            uf.union(p, q);
        }
        res++;
        if(cnt == 1) break;
      }
      if(cnt == 1) StdOut.println(res);
      else StdOut.print("FAILED");
   }
}
