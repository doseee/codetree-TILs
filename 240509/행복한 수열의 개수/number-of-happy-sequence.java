import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    int[][] a = new int[n][n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++)
        a[i][j] = Integer.parseInt(st.nextToken());
    }

    int ans = 0;
    for (int i = 0; i < n; i++) {
      int t = a[i][0], cnt = 1;
      if (cnt == m) {
        ans++;
        continue;
      }
      for (int j = 1; j < n; j++) {
        if (cnt == m) {
          ans++;
          break;
        }
        if (t == a[i][j]) cnt++;
        else {
          t = a[i][j];
          cnt = 1;
        }
        if (cnt == m && j == n - 1)
          ans++;
      }
    }

    for (int i = 0; i < n; i++) {
      int t = a[0][i], cnt = 1;
      if (cnt == m) {
        ans++;
        continue;
      }
      for (int j = 1; j < n; j++) {
        if (cnt == m) {
          ans++;
          break;
        }
        if (t == a[j][i]) cnt++;
        else {
          t = a[j][i];
          cnt = 1;
        }
        if (cnt == m && j == n - 1)
          ans++;
      }
    }

    System.out.print(ans);
  }
}