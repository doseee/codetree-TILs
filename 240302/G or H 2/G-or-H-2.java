import java.awt.Point;
import java.util.*;
import java.io.*;

public class Main {

  static Point[] a;
  static int n, ans;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());

    a = new Point[n];
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      char c = st.nextToken().charAt(0);
      int y = c == 'G' ? 0 : 1;
      a[i] = new Point(x, y);
    }

    Arrays.sort(a, new Comparator<Point>() {
      @Override
      public int compare(Point o1, Point o2) {
        return o1.x - o2.x;
      }
    });

    for (int i = 0; i < n - 1; i++) {
      if (a[i].y == 0)
        dfs(1,0, i, i + 1);
      else
        dfs(0,1, i, i + 1);
    }

    System.out.print(ans);
  }

  public static void dfs(int g, int h, int s, int e) {
    if (e >= n) {
      ans = Math.max(ans, (a[e - 1].x - a[s].x));
      return;
    }
    if (g != 0 && h != 0 && g == h)
      ans = Math.max(ans, (a[e - 1].x - a[s].x));

    if (a[e].y == 0)
      dfs(g + 1, h, s, e + 1);
    else
      dfs(g,h + 1, s, e + 1);
  }
}