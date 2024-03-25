import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {
  static int[][] a;
  static int[] dx = {1, 0, 0, -1}, dy = {0, 1, -1, 0}, select;
  static int n, k, m, ans, idx;
  static boolean[][] visit;
  static Point[] list, rock;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    idx = 0;
    a = new int[n][n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        a[i][j] = Integer.parseInt(st.nextToken());
        if (a[i][j] == 1)
          idx++;
      }
    }

    rock = new Point[idx];
    int t = 0;
    for (int i = 0; i < n; i++)
      for (int j = 0; j < n; j++)
        if (a[i][j] == 1)
          rock[t++] = new Point(i, j);


    list = new Point[k];
    for (int i = 0; i < k; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken()) - 1;
      int y = Integer.parseInt(st.nextToken()) - 1;
      list[i] = new Point(x, y);
    }

    ans = 0;
    select = new int[m];
    comb(0, 0);

    System.out.print(ans);
  }

  public static void comb(int ix, int cnt) {
    if (cnt == m) {
      int[][] t = new int[n][n];
      for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++)
          t[i][j] = a[i][j];

      for (int i = 0; i < m; i++) {
        Point p = rock[select[i]];
        t[p.x][p.y] = 0;
      }

      bfs(t);

      return;
    }

    for (int i = ix; i < idx; i++) {
      select[cnt] = i;
      comb(i + 1, cnt + 1);
    }
  }

  public static void bfs(int[][] t) {
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
        if (range(nx, ny) && !visit[nx][ny] && t[nx][ny] == 0) {
          visit[nx][ny] = true;
          q.add(new Point(nx, ny));
        }
      }
    }

    int cnt = 0;
    for (int i = 0; i < n; i++)
      for (int j = 0; j < n; j++)
        if (visit[i][j])
          cnt++;

    ans = Math.max(ans, cnt);
  }

  public static boolean range(int nx, int ny) {
    return nx >= 0 && nx < n && ny >= 0 && ny < n;
  }
}