import java.util.*;
import java.io.*;

public class Main {

  static char[][] map;
  static int n, m, ans;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    map = new char[n][m];
    for (int i = 0; i < n; i++) {
      String s = br.readLine();
      map[i] = s.toCharArray();
    }

    ans = 0;

    //가로
    for (int i = 0; i < n; i++) {
      StringBuilder t = new StringBuilder();
      for (int j = 0; j < m - 2; j++) {
        for (int k = 0; k < 3; k++)
          t.append(map[i][j + k]);
        if (t.length() == 3) {
          check(t);
          t = new StringBuilder();
        }
      }
    }

    //세로
    for (int i = 0; i < m; i++) {
      StringBuilder t = new StringBuilder();
      for (int j = 0; j < n - 2; j++) {
        for (int k = 0; k < 3; k++)
          t.append(map[j + k][i]);
        if (t.length() == 3) {
          check(t);
          t = new StringBuilder();
        }
      }
    }

    //대각선
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (map[i][j] == 'L' || map[i][j] == 'E') {
          move1(i, j, new StringBuilder().append(map[i][j]));
          move2(i, j, new StringBuilder().append(map[i][j]));
        }
      }
    }


    System.out.print(ans);
  }

  public static void move1(int x, int y, StringBuilder s) {
    if (s.length() == 3) {
      check(s);
      return;
    }

    if (range(x + 1, y + 1))
      move1(x + 1, y + 1, s.append(map[x + 1][y + 1]));
  }

  public static void move2(int x, int y, StringBuilder s) {
    if (s.length() == 3) {
      check(s);
      return;
    }

    if (range(x + 1, y - 1))
      move2(x + 1, y - 1, s.append(map[x + 1][y - 1]));
  }

  public static void check(StringBuilder s) {
    if (s.toString().equals("LEE"))
      ans++;
    s.reverse();
    if (s.toString().equals("LEE"))
      ans++;
  }

  public static boolean range(int nx, int ny) {
    return nx >= 0 && nx < n && ny >= 0 && ny < m;
  }
}