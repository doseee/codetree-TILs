import java.util.*;
import java.io.*;

public class Main {

  static int n, ans;
  static int[] a;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());

    a = new int[n];
    for (int i = 0; i < n; i++)
      a[i] = Integer.parseInt(st.nextToken());

    ans = n;
    for (int i = 2; i <= n; i++)
      calc(i);

    System.out.print(ans);
  }

  public static void check(double x, int s, int e) {
    for (int i = s; i <= e; i++) {
      if (x == a[i]) {
        ans++;
        return;
      }
    }
  }

  public static void calc(int d) {
    int sum = 0;
    for (int i = 0; i < d; i++)
      sum += a[i];

    check((double) sum / d, 0, d - 1);

    for (int i = d; i < n; i++) {
      sum -= a[i - d];
      sum += a[i];
      check((double) sum / d, i - d + 1, i);
    }
  }
}