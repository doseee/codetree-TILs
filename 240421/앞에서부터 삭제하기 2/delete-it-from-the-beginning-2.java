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

    double ans= 0, sum = 0, cnt = 2;
    PriorityQueue<Integer> q = new PriorityQueue<>();
    for (int i = n - 1; i >= n - 2; i--) {
        q.add(a[i]);
        sum += a[i];
    }

    for (int i = n - 3; i >= 0; i--) {
      int t = q.poll();
      sum -= t;
      ans = Math.max(ans, sum / (cnt - 1));
      if (i == 0) break;
      q.add(t);
      sum += t;

      q.add(a[i]);
      sum += a[i];
      cnt++;
    }

    System.out.printf("%.2f", ans);
  }
}