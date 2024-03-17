import java.util.*;
import java.io.*;

public class Main {
  static int[][] a, g;
  static int[] dx = {1, 0, 0, -1}, dy = {0, 1, -1, 0};
  static int ans, n, cnt, idx;
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

    idx = 0;
    visit = new boolean[n][n];
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (a[i][j] == 1 && !visit[i][j]) {
          idx++;
          cnt = 1;
          dfs(i, j);
          list.add(cnt);
        }
      }
    }
    
    System.out.println(idx);
    Collections.sort(list);
    for (Integer i : list)
      System.out.println(i);
  }

  public static void dfs(int x, int y) {
    visit[x][y] = true;

    for (int k = 0; k < 4; k++) {
      int nx = x + dx[k], ny = y + dy[k];
      if (range(nx, ny) && a[nx][ny] == 1 && !visit[nx][ny]) {
        visit[nx][ny] = true;
        cnt++;
        dfs(nx, ny);
      }
    }
  }

  public static boolean range(int nx, int ny) {
    return nx >= 0 && nx < n && ny >=0 && ny < n;
  }
}