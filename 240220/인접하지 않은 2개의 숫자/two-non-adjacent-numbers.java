import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    int[] a = new int[n];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++)
      a[i] = Integer.parseInt(st.nextToken());

    int ans = 0;
    for (int i = 0; i < n; i++)
      for (int j = 0; j < n; j++)
        if (Math.abs(i - j) > 1)
          ans = Math.max(ans, a[i] + a[j]);

    System.out.print(ans);
  }
}