import java.util.*;
import java.io.*;

public class Main {

  static int[][] a;
  static int n, ans;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());

    a = new int[n][n];
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++)
        a[i][j] = Integer.parseInt(st.nextToken());
    }

    ans = 0;
    for (int i = 0; i < n; i++) {
      int sum = calc(i, 0);
      ans = Math.max(ans, sum);
      for (int j = 3; j < n; j++) {
        for (int k = i; k < i + 3; k++) {
          if (k >= n) break;
          sum -= a[k][j - 3];
          sum += a[k][j];
        }
        ans = Math.max(ans, sum);
      }
    }

    System.out.print(ans);
  }

  public static int calc(int x, int y) {
    int sum = 0;

    int nx = x + 3, ny = y + 3;
    if (nx > n || ny > n) {
      nx = n; ny = n;
    }

    for (int i = x; i < nx; i++)
      for (int j = y; j < ny; j++)
        sum += a[i][j];
    
    return sum;
  }
}