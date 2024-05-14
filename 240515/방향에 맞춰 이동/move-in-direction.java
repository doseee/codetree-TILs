import java.util.*;
import java.io.*;

public class Main {

  static int[] dx = {0, -1, 1, 0}, dy = {-1, 0, 0, 1}; //w,s,n,e

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int x = 0, y = 0;
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      char c = st.nextToken().charAt(0);
      int t = Integer.parseInt(st.nextToken());

      int d = 0;
      switch (c) {
        case 'S':
          d = 1;
          break;
        case'N':
          d = 2;
          break;
        case 'E':
          d = 3;
          break;
      }

      x += dx[d] * t;
      y += dy[d] * t;
    }

    System.out.print(y + " " + x);
  }
}