import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());

    PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o2 - o1;
      }
    });

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
     int x = Integer.parseInt(br.readLine());
     if (x != 0)
       q.add(x);
     else {
       if (q.isEmpty())
         sb.append(0 + "\n");
       else
         sb.append(q.poll() + "\n");
     }
    }

    bw.write(sb.toString());
    bw.close(); br.close();
  }
}