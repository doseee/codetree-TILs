import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[][] a = new int[4][n];
    for (int i = 0; i < 4; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++)
        a[i][j] = Integer.parseInt(st.nextToken());
    }

    int ans = 0;
    HashMap<Integer, Integer> h = new HashMap<>();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        int x = a[0][i] + a[1][j];
        h.put(x, h.getOrDefault(x, 0) + 1);
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        int x = a[1][i] + a[2][j];
        if (h.containsKey(x))
          ans++;
        else
          h.put(x, h.getOrDefault(x, 0) + 1);
      }
    }

    System.out.print(ans);
  }
}