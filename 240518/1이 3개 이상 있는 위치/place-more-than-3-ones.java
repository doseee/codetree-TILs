import java.util.*;
import java.io.*;

public class Main {

  static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
  static int[][] a;
  static int n;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());
    a = new int[n][n];
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++)
        a[i][j] = Integer.parseInt(st.nextToken());
    }

    int ans = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        int cnt = 0;
        for (int k = 0; k < 4; k++) {
          int nx = i + dx[k], ny = j + dy[k];
          if (range(nx, ny) && a[nx][ny] == 1)
            cnt++;
        }

        if (cnt >= 3)
          ans++;
      }
    }

    System.out.print(ans);
  }

  public static boolean range(int nx, int ny) {
    return nx >= 0 && nx < n && ny >= 0 && ny < n;
  }
}