import java.util.*;
import java.io.*;

public class Main {

  static int n, s, ans;
  static int[] a, select;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    s = Integer.parseInt(st.nextToken());

    a = new int[n];
    st = new StringTokenizer(br.readLine());
    int sum = 0;
    for (int i = 0; i < n; i++) {
      a[i] = Integer.parseInt(st.nextToken());
      sum += a[i];
    }

    ans = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++)
      for (int j = i + 1; j < n; j++)
        ans = Math.min(Math.abs(sum - (a[i] + a[j]) - s), ans);

    System.out.print(ans);
  }
}