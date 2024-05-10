import java.util.*;
import java.io.*;

public class Main {

  static int[][] dx = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}}, dy = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
  static int[] fx = {-1, 1, 0, 0}, fy = {0, 0, 1, -1};
  static int n, m, ans;
  static int[][] a;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    a = new int[n][n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++)
        a[i][j] = Integer.parseInt(st.nextToken());
    }

    ans = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        check1(i, j);
        check2(i, j);
      }
    }

    System.out.print(ans);
  }

  public static void check1(int x, int y) {
    for (int k = 0; k < 4; k++) {
      int sum = a[x][y], cnt = 0;
      for (int i = 0; i < 2; i++) {
        int nx = x + dx[k][i], ny = y + dy[k][i];
        if (range(nx, ny)) {
          cnt++;
          sum += a[nx][ny];
        }
      }
      if (cnt == 2)
        ans = Math.max(ans, sum);
    }
  }

  public static void check2(int x, int y) {
    int sum = a[x][y], cnt = 0;
    for (int k = 0; k < 4; k++) {
      if (k == 2) {
        if (cnt == 2)
          ans = Math.max(ans, sum);
        sum = a[x][y]; cnt = 0;
      }
      int nx = x + fx[k], ny = y + fy[k];
      if (range(nx, ny)) {
        cnt++;
        sum += a[nx][ny];
      }
    }
  }

  public static boolean range(int nx, int ny) {
    return nx >= 0 && nx < n && ny >= 0 && ny < n;
  }
}