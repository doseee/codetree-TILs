import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] a = new int[n];
    for (int i = 0; i < n; i++)
      a[i] = Integer.parseInt(st.nextToken());

    double ans= 0;
    for (int i = 0; i < n - 2; i++) {
      PriorityQueue<Integer> q = new PriorityQueue<>();
      for (int j = i + 1; j < n; j++)
        q.add(a[j]);

      q.poll();

      double sum = 0, cnt = 0;
      while (!q.isEmpty()) {
        sum += q.poll();
        cnt++;
      }

      sum /= cnt;
      ans = Math.max(ans, sum);
    }


    System.out.printf("%.2f", ans);
  }
}