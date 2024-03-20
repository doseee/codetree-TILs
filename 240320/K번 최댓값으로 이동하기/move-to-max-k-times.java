import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {
  static int[][] a;
  static int[] dx = {1, 0, 0, -1}, dy = {0, 1, -1, 0};
  static int n, k, r, c;
  static boolean[][] visit;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    a = new int[n][n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++)
        a[i][j] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(br.readLine());
    r = Integer.parseInt(st.nextToken()) - 1;
    c = Integer.parseInt(st.nextToken()) - 1;

    for (int i = 0; i < k; i++)
      bfs();

    System.out.print((r + 1) + " " + (c + 1));
  }

  public static void bfs() {
    visit = new boolean[n][n];
    visit[r][c] = true;
    Queue<Point> q = new ArrayDeque<>();
    q.add(new Point(r, c));

    int x = a[r][c], max = 0;
    while (!q.isEmpty()) {
      Point p = q.poll();
      for (int k = 0; k < 4; k++) {
        int nx = p.x + dx[k], ny = p.y + dy[k];
        if (range(nx, ny) && a[nx][ny] < x && !visit[nx][ny]) {
          if (max == a[nx][ny]) {
            if (r > nx || (r == nx && c > ny)) {
              r = nx; c = ny;
            }
          }
          if (max < a[nx][ny]) {
            max = a[nx][ny];
            r = nx; c = ny;
          }
          visit[nx][ny] = true;
          q.add(new Point(nx, ny));
        }
      }
    }
  }

  public static boolean range(int nx, int ny) {
    return nx >= 0 && nx < n && ny >= 0 && ny < n;
  }
}