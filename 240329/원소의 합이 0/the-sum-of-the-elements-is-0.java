import java.util.*;
import java.io.*;
import java.util.Map.Entry;

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
    HashMap<Integer, Integer> h1 = new HashMap<>();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        int x = a[0][i] + a[1][j];
        h1.put(x, h1.getOrDefault(x, 0) + 1);
      }
    }

    HashMap<Integer, Integer> h2 = new HashMap<>();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        int x = a[2][i] + a[3][j];
        h2.put(x, h2.getOrDefault(x, 0) + 1);
      }
    }

    for (Entry<Integer, Integer> entry : h1.entrySet())
      if (h2.containsKey(entry.getKey() * -1))
        ans += entry.getValue() * h2.get(entry.getKey() * -1);

    System.out.print(ans);
  }
}