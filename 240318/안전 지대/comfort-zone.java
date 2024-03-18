import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {
  static int[][] a;
  static int[] dx = {1, 0, 0, -1}, dy = {0, 1, -1, 0};
  static int n, m;
  static boolean[][] visit;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    a = new int[n][m];
    int max = 0;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        a[i][j] = Integer.parseInt(st.nextToken());
        max = Math.max(a[i][j], max);
      }
    }

    int ans = 0, k = 0;
    for (int d = 1; d <= max; d++) {
      int idx = 0;
      visit = new boolean[n][m];
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if (a[i][j] > d && !visit[i][j]) {
            idx++;
            dfs(i, j, d);
          }
        }
      }
      if (ans < idx) {
        ans = idx;
        k = d;
      }

    }

    if (k == 0)
      k = 1;

    System.out.println(k + " " + ans);

  }

  public static void dfs(int x, int y, int d) {
    visit[x][y] = true;

    for (int k = 0; k < 4; k++) {
      int nx = x + dx[k], ny = y + dy[k];
      if (range(nx, ny) && a[nx][ny] > d && !visit[nx][ny]) {
        visit[nx][ny] = true;
        dfs(nx, ny, d);
      }
    }
  }

  public static boolean range(int nx, int ny) {
    return nx >= 0 && nx < n && ny >= 0 && ny < m;
  }
}