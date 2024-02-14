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

    int ans = 0;
    for (int i = 0; i < n; i++) {
      int x = a[i], cnt = 1;
      for (int j = i + 1; j < n; j++) {
        if (x < a[j]) {
          x = a[j];
          cnt++;
          if (cnt >= 3)
            ans++;
        }
      }
    }

    System.out.print(ans);
  }
}