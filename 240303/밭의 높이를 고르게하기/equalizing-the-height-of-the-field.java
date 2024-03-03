import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int h = Integer.parseInt(st.nextToken());
    int t = Integer.parseInt(st.nextToken());
    
    int[] a = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++)
      a[i] = Integer.parseInt(st.nextToken());

    int ans = 0;
    for (int i = 0; i < t; i++)
      ans += Math.abs(h - a[i]);

    int sum = ans;
    for (int i = t; i < n; i++) {
      sum -= Math.abs(h - a[i - t]);
      sum += Math.abs(h - a[i]);
      ans = Math.min(ans, sum);
    }

    System.out.print(ans);
  }
}