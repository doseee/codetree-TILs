import java.util.*;
import java.io.*;

public class Main {

  static int[] select;
  static int k, n;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    k = Integer.parseInt(st.nextToken());
    n = Integer.parseInt(st.nextToken());

    select = new int[n];
    perm(0);
  }

  public static void perm(int cnt) {
    if (cnt == n) {
      for (int i = 0; i < n; i++)
        System.out.print(select[i] + " ");
      System.out.println();
      return;
    }

    for (int i = 1; i <= k; i++) {
      select[cnt] = i;
      perm(cnt + 1);
    }
  }
}