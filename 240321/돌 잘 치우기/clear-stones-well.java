import java.util.*;
import java.io.*;

public class Main {
  static int[][] a;
  static int[] dx = {1, 0, 0, -1}, dy = {0, 1, -1, 0};
  static int n, k, m, ans;
  static boolean[][] visit;
  static Point[] list;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    a = new int[n][n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++)
        a[i][j] = Integer.parseInt(st.nextToken());
    }

    list = new Point[k];
    for (int i = 0; i < k; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken()) - 1;
      int y = Integer.parseInt(st.nextToken()) - 1;
      list[i] = new Point(x, y, 1, 0);
    }

    ans = 0;
    bfs();

    System.out.print(ans);
  }

  public static void bfs() {
    visit = new boolean[n][n];
    Queue<Point> q = new ArrayDeque<>();

    for (int i = 0; i < k; i++) {
      Point p = list[i];
      visit[p.x][p.y] = true;
      q.add(p);
    }

    while (!q.isEmpty()) {
      Point p = q.poll();

      for (int k = 0; k < 4; k++) {
        int nx = p.x + dx[k], ny = p.y + dy[k];
        if (range(nx, ny) && !visit[nx][ny]) {
          if (a[nx][ny] == 0) {
            visit[nx][ny] = true;
            q.add(new Point(nx, ny, p.cnt + 1, p.d));
          }
          else
            if (p.d < m)
              q.add(new Point(nx, ny, p.cnt + 1, p.d + 1));
        }
      }
    }

    int cnt = 0;
    for (int i = 0; i < n; i++)
      for (int j = 0; j < n; j++)
        if (visit[i][j])
          cnt++;

    ans = Math.max(ans, cnt + m);
  }

  public static boolean range(int nx, int ny) {
    return nx >= 0 && nx < n && ny >= 0 && ny < n;
  }

  static class Point {
    int x, y, cnt, d;

    public Point(int x, int y, int cnt, int d) {
      this.x = x;
      this.y = y;
      this.cnt = cnt;
      this.d = d;
    }
  }
}