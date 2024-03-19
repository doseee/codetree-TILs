import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {
  static int[][] a;
  static int[] dx = {1, 0, 0, -1}, dy = {0, 1, -1, 0};
  static int n;
  static boolean[][] visit;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    a = new int[n][n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++)
        a[i][j] = Integer.parseInt(st.nextToken());
    }

    visit = new boolean[n][n];
    for (int i = 0; i < k; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      bfs(x - 1, y - 1);
    }

    int ans = 0;
    for (int i = 0; i < n; i++)
      for (int j = 0; j < n; j++)
        if (visit[i][j])
          ans++;

    System.out.print(ans);
  }

  public static void bfs(int x, int y) {
    boolean[][] visited = new boolean[n][n];
    visited[x][y] = true;
    visit[x][y] = true;
    Queue<Point> q = new ArrayDeque<>();
    q.add(new Point(x, y));

    while (!q.isEmpty()) {
      Point p = q.poll();
      for (int k = 0; k < 4; k++) {
        int nx = p.x + dx[k], ny = p.y + dy[k];
        if (range(nx, ny) && a[nx][ny] == 0 && !visited[nx][ny]) {
          visit[nx][ny] = true;
          visited[nx][ny] = true;
          q.add(new Point(nx, ny));
        }
      }
    }
  }

  public static boolean range(int nx, int ny) {
    return nx >= 0 && nx < n && ny >= 0 && ny < n;
  }
}