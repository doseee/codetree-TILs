import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};

    int n = Integer.parseInt(br.readLine());
    int x = 0, y = 0, cnt = 0, f = 0;
    ex: for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      char c = st.nextToken().charAt(0);
      int t = Integer.parseInt(st.nextToken());

      int d = 0;
      if (c == 'N')
        d = 1;
      if (c == 'W')
        d = 2;
      if (c == 'S')
        d = 3;

      for (int j = 0; j < t; j++) {
        cnt++;
        x += dx[d];
        y += dy[d];
        if (x == 0 && y == 0) {
          f = 1;
          System.out.print(cnt);
          break ex;
        }
      }
    }

    if (f == 0)
      System.out.print(-1);
  }
}