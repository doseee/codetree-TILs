import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {

  static int[] dx = {-1, 1, 0, 0, -1, 1, 1, -1}, dy = {0, 0, -1, 1, -1, 1, -1, 1}, select;
  static Point[] a;
  static int ans, n, idx;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());
    a = new Point[n * n];
    idx = 0;
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        int t = Integer.parseInt(st.nextToken());
        if (t == 1)
          a[idx++] = new Point(i, j);
      }
    }

    ans = 0;
    select = new int[idx];
    perm(0);

    System.out.print(ans);
  }

  public static void first(int[][] tmp, Point p) {
    for (int i = 0; i < 2; i++) {
      for (int j = 1; j <= 2; j++) {
        int nx = p.x + dx[i] * j, ny = p.y + dy[i] * j;
        if (range(nx, ny))
          tmp[nx][ny] = 1;
      }
    }
  }

  public static void second(int[][] tmp, Point p) {
    for (int i = 0; i < 4; i++) {
      int nx = p.x + dx[i], ny = p.y + dy[i];
        if (range(nx, ny))
          tmp[nx][ny] = 1;
    }
  }

  public static void third(int[][] tmp, Point p) {
    for (int i = 4; i < 8; i++) {
      int nx = p.x + dx[i], ny = p.y + dy[i];
      if (range(nx, ny))
        tmp[nx][ny] = 1;
    }
  }

  public static void perm(int cnt) {
    if (cnt == idx) {
      int[][] tmp = new int[n][n];
      for (int i = 0; i < idx; i++) {
        tmp[a[i].x][a[i].y] = 1;
        if (select[i] == 0)
          first(tmp, a[i]);
        else if (select[i] == 1)
          second(tmp, a[i]);
        else
          third(tmp, a[i]);
      }

      int t = 0;
      for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++)
          if (tmp[i][j] == 1)
            t++;

      ans = Math.max(ans, t);
      
      return;
    }

    for (int i = 0; i < 3; i++) {
      select[cnt] = i;
      perm(cnt + 1);
    }
  }

  public static boolean range(int nx, int ny) {
    return nx >= 0 && nx < n && ny >= 0 && ny < n;
  }
}