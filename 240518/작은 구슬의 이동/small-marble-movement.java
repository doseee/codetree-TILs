import java.util.*;
import java.io.*;

public class Main {

  static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
  static int n;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    int t = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    int x = Integer.parseInt(st.nextToken());
    int y = Integer.parseInt(st.nextToken());
    char c = st.nextToken().charAt(0);

    int d = 0;
    if (c == 'D')
      d = 2;
    if (c == 'R')
      d = 1;
    if (c == 'L')
      d = 3;

    for (int i = 0; i < t; i++) {
      int nx = x + dx[d], ny = y + dy[d];
      if (range(nx, ny)) {
        x = nx; y = ny;
      }
      else {
        d += 2;
        if (d >= 4)
          d -= 4;
      }
    }

    System.out.print(x + " " + y);
  }

  public static boolean range(int nx, int ny) {
    return nx >= 1 && nx <= n && ny >= 1 && ny <= n;
  }
}