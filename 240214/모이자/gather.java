import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    int[] a = new int[n];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++)
      a[i] = Integer.parseInt(st.nextToken());

    int ans = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      int sum = 0;
      for (int j = 0; j < n; j++)
        sum += a[j] * Math.abs(i - j);
      ans = Math.min(ans, sum);
    }

    System.out.print(ans);
  }
}