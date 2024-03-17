import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {
  static Point[] a;
  static int ans, n, m;
  static boolean[] visit;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    a = new Point[m];
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      a[i] = new Point(x, y);
    }

    ans = 0;
    visit = new boolean[n + 1];
    for (int i = 0; i < m; i++)
      if (a[i].x == 1 || a[i].y == 1)
        dfs(1);

    for (int i = 2; i <= n; i++)
      if (visit[i])
        ans++;

    System.out.print(ans);
  }

  public static void dfs(int idx) {
    if (visit[idx]) return;
    visit[idx] = true;

    for (int i = 0; i < m; i++) {
      if (a[i].x == idx)
        dfs(a[i].y);
      if (a[i].y == idx)
        dfs(a[i].x);
    }
  }
}