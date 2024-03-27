import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {
  static int[][] a;
  static int[] dx = {1, 0, 0, -1}, dy = {0, 1, -1, 0}, select;
  static int n, k, u, d, ans;
  static boolean[][] visit;
  static Point[] list;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    u = Integer.parseInt(st.nextToken());
    d = Integer.parseInt(st.nextToken());

    a = new int[n][n];
    list = new Point[n * n];
    int idx = 0;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        a[i][j] = Integer.parseInt(st.nextToken());
        list[idx++] = new Point(i, j);
      }
    }

    ans = 0;
    select = new int[k];
    comb(0, 0);

    System.out.print(ans);
  }

  public static void comb(int cnt, int idx) {
    if (cnt == k){
      bfs();
      return;
    }

    for (int i = idx; i < n * n; i++) {
      select[cnt] = i;
      comb(cnt + 1, i + 1);
    }
  }

  public static void bfs() {
    visit = new boolean[n][n];
    Queue<Point> q = new ArrayDeque<>();
    for (int i = 0; i < k; i++) {
      Point p = list[select[i]];
      visit[p.x][p.y] = true;
      q.add(new Point(p.x, p.y));
    }

    while (!q.isEmpty()) {
      Point p = q.poll();
      for (int k = 0; k < 4; k++) {
        int nx = p.x + dx[k], ny = p.y + dy[k];
        if (range(nx, ny) && !visit[nx][ny]) {
          int t = Math.abs(a[nx][ny] - a[p.x][p.y]);
          if (t >= u && t <= d) {
            visit[nx][ny] = true;
            q.add(new Point(nx, ny));
          }
        }
      }
    }

    int cnt = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (visit[i][j])
          cnt++;
      }
    }

    ans = Math.max(ans, cnt);
  }

  public static boolean range(int nx, int ny) {
    return nx >= 0 && nx < n  && ny >= 0 && ny < n;
  }
}