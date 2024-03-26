import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {
  static int[][] a;
  static int[] dx = {1, 0, 0, -1}, dy = {0, 1, -1, 0};
  static int n, m, cnt, water;
  static boolean[][] visit;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    a = new int[n][m];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++)
        a[i][j] = Integer.parseInt(st.nextToken());
    }

    int t = 0;
    while (true) {
      bfs(0, 0);
      t++;
      if (water == n * m) break;
    }

    System.out.print(t + " " + cnt);
  }

  public static void bfs(int x, int y) {
    visit = new boolean[n][m];
    Queue<Point> q = new ArrayDeque<>();
    visit[x][y] = true;
    q.add(new Point(x, y));

    while (!q.isEmpty()) {
      Point p = q.poll();
      for (int k = 0; k < 4; k++) {
        int nx = p.x + dx[k], ny = p.y + dy[k];
        if (range(nx, ny) && !visit[nx][ny]) {
          visit[nx][ny] = true;
          if (a[nx][ny] == 1)
            a[nx][ny] = 2;
          if (a[nx][ny] == 0)
            q.add(new Point(nx, ny));
        }
      }
    }

    cnt = 0; water = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (a[i][j] == 2) {
          cnt++;
          a[i][j] = 0;
        }
        if (a[i][j] == 0)
          water++;
      }
    }
  }

  public static boolean range(int nx, int ny) {
    return nx >= 0 && nx < n  && ny >= 0 && ny < m;
  }
}