import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    int[] a = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++)
      a[i] = Integer.parseInt(st.nextToken());

    int sum = 0;
    for (int i = 0; i < k; i++)
      sum += a[i];

    int ans = 0;
    ans = Math.max(ans, sum);
    for (int i = k; i < n; i++) {
      sum -= a[i - k];
      sum += a[i];
      ans = Math.max(ans, sum);
    }

    System.out.print(ans);
  }
}