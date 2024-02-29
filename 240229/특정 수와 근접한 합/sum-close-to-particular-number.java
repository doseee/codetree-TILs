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
    for (int i = 0; i < n; i++)
      a[i] = Integer.parseInt(st.nextToken());

    select = new int[n - 2];
    ans = Integer.MAX_VALUE;

    boolean[] visit = new boolean[n];
    dfs(0, 0, visit);

    System.out.print(ans);
  }

  public static void dfs(int sum, int d, boolean[] visit) {
    if (d == n - 2) {
      ans = Math.min(ans, Math.abs(sum - s));
      return;
    }

    for (int i = 0; i < n; i++) {
      if (!visit[i]) {
        visit[i] = true;
        dfs(sum + a[i], d + 1, visit);
        visit[i] = false;
      }
    }
  }
}