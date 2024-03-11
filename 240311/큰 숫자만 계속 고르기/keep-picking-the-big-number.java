import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o2 - o1;
      }
    });

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++)
      q.add(Integer.parseInt(st.nextToken()));

    for (int i = 0; i < m; i++)
      q.add(q.poll() - 1);

    System.out.print(q.poll());
  }
}