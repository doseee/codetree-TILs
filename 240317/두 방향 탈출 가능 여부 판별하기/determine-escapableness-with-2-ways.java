import java.util.*;
import java.io.*;

public class Main {
  static int[][] a;
  static int[] dx = {1, 0}, dy = {0, 1};
  static int ans, n, m;
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

    ans = 0;
    visit = new boolean[n][m];
    visit[0][0] = true;
    dfs(0, 0);

    System.out.print(ans);
  }

  public static void dfs(int x, int y) {
    if (x == n - 1 && y == m - 1) {
      ans = 1;
      return;
    }

    for (int k = 0; k < 2; k++) {
      int nx = x + dx[k], ny = y + dy[k];
      if (range(nx, ny) && a[nx][ny] == 1 && !visit[nx][ny]) {
        visit[nx][ny] = true;
        dfs(nx, ny);
      }
    }
  }

  public static boolean range(int nx, int ny) {
    return nx >= 0 && nx < n && ny >=0 && ny < m;
  }
}