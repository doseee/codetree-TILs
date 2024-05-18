import java.util.*;
import java.io.*;

public class Main {

  static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
  static int[][] a;
  static int n, m;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    a = new int[n][m];
    int idx = 2, d = 0, x = 0, y = 0;
    a[x][y] = 1;
    while (true) {
        if (idx >= n * m + 1)
          break;
        int nx = x + dx[d], ny = y + dy[d];
        if (range(nx, ny) && a[nx][ny] == 0) {
          a[nx][ny] = idx++;
          x = nx; y = ny;
        }
        else {
          d++;
          if (d >= 4)
            d = 0;
        }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++)
        System.out.print(a[i][j] + " ");
      System.out.println();
    }
  }

  public static boolean range(int nx, int ny) {
    return nx >= 0 && nx < n && ny >= 0 && ny < m;
  }
}