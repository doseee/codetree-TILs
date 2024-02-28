import java.util.*;
import java.io.*;

public class Main {

  static int n, ans;
  static int[][] a;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());
    a = new int[n][n];
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++)
        a[i][j] = Integer.parseInt(st.nextToken());
    }

    calc();
    calc();

    System.out.print(ans);
  }

  public static void calc() {
    int max = 0, x = 0, y = 0;
    for (int i = 0; i < n; i++) {
      int sum = 0;
      for (int j = 0; j < 3; j++)
        sum += a[i][j];

      if (max < sum) {
        x = i; y = 2;
        max = sum;
      }

      for (int j = 3; j < n; j++) {
        sum -= a[i][j - 3];
        sum += a[i][j];

        if (max < sum) {
          x = i; y = j;
          max = sum;
        }
      }
    }

    ans += max;
    int t = y - 3;
    if (t < 0)
        t = 0;
    for (int j = y; j > t; j--)
      a[x][j] = 0;
  }
}