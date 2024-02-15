import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    int[][] a = new int[n][n];
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++)
        a[i][j] = Integer.parseInt(st.nextToken());
    }

    int ans = 0;

    for (int i = 0; i < n; i++) {
      int sum = 0;

      for (int j = 0; j < 3; j++)
        sum += a[i][j];

      ans = Math.max(ans, sum);
      for (int j = 3; j < n; j++) {
        sum -= a[i][j - 3];
        sum += a[i][j];
        ans = Math.max(ans, sum);
      }
    }

    System.out.print(ans);
  }
}