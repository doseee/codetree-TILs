import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {
  static Point[] a;
  static int ans, n, m;

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
    boolean[] visit = new boolean[n + 1];
    for (int i = 0; i < m; i++)
      if (a[i].x == 1) 
        dfs(1,0, visit);
    
    System.out.print(ans);
  }

  public static void dfs(int idx, int cnt, boolean[] visit) {
    if (visit[idx]) return;
    visit[idx] = true;

    for (int i = 0; i < m; i++) {
      if (!visit[a[i].y] && a[i].x == idx) {
        ans = Math.max(ans, cnt + 1);
        dfs(a[i].y, cnt + 1, visit);
      }

      if (!visit[a[i].x] && a[i].y == idx) {
        ans = Math.max(ans, cnt + 1);
        dfs(a[i].x, cnt + 1, visit);
      }
    }
  }
}