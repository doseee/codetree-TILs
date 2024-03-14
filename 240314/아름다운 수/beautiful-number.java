import java.util.*;
import java.io.*;

public class Main {

  static String s;
  static String[] a = {"1", "22", "333", "4444"};
  static int ans, n;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());
    ans = 0;
    perm("");

    System.out.print(ans);
  }

  public static void perm(String s) {
    if (s.length() >= n) {
      if(s.length() == n)
        ans++;
      return;
    }

    for (int i = 0; i < 4; i++) {
      perm( s + a[i]);
    }
  }
}