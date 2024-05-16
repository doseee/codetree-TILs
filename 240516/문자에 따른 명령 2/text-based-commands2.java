import java.util.*;
import java.io.*;

public class Main {

  static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    char[] o = br.readLine().toCharArray();

    int x = 0, y = 0, d = 0;
    for (int i = 0; i < o.length; i++) {
      char c = o[i];
      if (c == 'R') {
        d++;
        if (d >= 4)
          d = 0;
      }

      if (c == 'L') {
        d--;
        if (d < 0)
          d = 3;
      }
      if (c == 'F') {
        x += dx[d];
        y += dy[d];
      }
    }

    System.out.print(y + " " + x);
  }
}