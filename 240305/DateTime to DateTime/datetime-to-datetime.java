import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());

    int ans = 0;
    int x = c - 11;
    if (x < 0) {
      ans += 60;
      b--;
    }
    ans += x;

    x = b - 11;
    if (x < 0) {
      x += 24;
      a--;
    }
    ans += x * 60;

    if (a > 11)
      ans += ((a - 11) * 60) * 24;

    System.out.print(ans);
  }
}