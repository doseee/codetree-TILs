import java.util.*;
import java.io.*;
import java.util.Map.Entry;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    int[] a = new int[101];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      a[y] += x;
    }

    int sum = 0, ans = 0, max = k * 2;
    if (max > 101) max = 100;
    for (int i = 0; i <= max; i++)
      sum += a[i];

    ans = Math.max(ans, sum);

    for (int i = k * 2; i < 100; i++) {
      sum -= a[i - (k * 2)];
      sum += a[i + 1];
      ans = Math.max(ans, sum);
    }

    System.out.print(ans);
  }
}