import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {
  static int[][] a;
  static int[] dx = {1, 0, 0, -1}, dy = {0, 1, -1, 0};
  static int n, cnt;
  static boolean[][] visit;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());

    a = new int[n][n];
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++)
        a[i][j] = Integer.parseInt(st.nextToken());
    }

    int idx = 0, max = 0;
    visit = new boolean[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (!visit[i][j]) {
          cnt = 1;
          dfs(i, j, a[i][j]);
          if (cnt >= 4)
            idx++;
          max = Math.max(max, cnt);
        }
      }
    }

    System.out.print(idx + " " + max);
  }

  public static void dfs(int x, int y, int d) {
    visit[x][y] = true;

    for (int k = 0; k < 4; k++) {
      int nx = x + dx[k], ny = y + dy[k];
      if (range(nx, ny) && a[nx][ny] == d && !visit[nx][ny]) {
        cnt++;
        visit[nx][ny] = true;
        dfs(nx, ny, d);
      }
    }
  }

  public static boolean range(int nx, int ny) {
    return nx >= 0 && nx < n && ny >= 0 && ny < n;
  }
}