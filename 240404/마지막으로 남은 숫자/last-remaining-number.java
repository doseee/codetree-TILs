import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o2 - o1;
      }
    });


    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++)
      q.add(Integer.parseInt(st.nextToken()));

    int ans = 0;
    while (!q.isEmpty()) {
      int x = q.poll();
      int y = -1;
      if (!q.isEmpty())
        y = q.poll();
      if (y == -1)
        ans = y;
      else {
        q.add(Math.abs(x - y));
      }
      if (q.isEmpty())
        ans = x;
    }

    System.out.print(ans);
  }
}