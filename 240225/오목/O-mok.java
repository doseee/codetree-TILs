import java.util.*;
import java.io.*;

public class Main {

  static int[][] map;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    map = new int[19][19];
    for (int i = 0; i < 19; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 19; j++)
        map[i][j] = Integer.parseInt(st.nextToken());
    }

    //가로
    for (int i = 0; i < 19; i++) {
      int t = map[i][0], cnt = 0;
      if (t != 0) cnt++;

      for (int j = 1; j < 19; j++) {
        if (t != 0) {
          if (t == map[i][j])
            cnt++;
          else {
            t = map[i][j];
            cnt = 0;
          }
        }
        else {
          t = map[i][j];
          cnt = 1;
        }

        if (cnt == 5) {
          System.out.print(t + "\n" + (i + 1) + " " + (j - 1));
          System.exit(0);
        }
      }
    }

    //세로
    for (int i = 0; i < 19; i++) {
      int t = map[0][i], cnt = 0;
      if (t != 0) cnt++;

      for (int j = 1; j < 19; j++) {
        if (t != 0) {
          if (t == map[j][i])
            cnt++;
          else {
            t = map[j][i];
            cnt = 0;
          }
        }
        else {
          t = map[j][i];
          cnt = 1;
        }

        if (cnt == 5) {
          System.out.print(t + "\n" + (i - 1) + " " + (j + 1));
          System.exit(0);
        }
      }
    }

    //대각선
    for (int i = 0; i < 19; i++) {
      for (int j = 0; j < 19; j++) {
        if (map[i][j] != 0) {
          move1(map[i][j], i, j, 1);
          move2(map[i][j], i, j, 1);
        }
      }
    }
  }

  public static void move1(int t, int x, int y, int cnt) {
    if (cnt == 5) {
      System.out.print(t + "\n" + (x - 1) + " " + (y - 1));
      System.exit(0);
      return;
    }

    if (range(x + 1, y + 1) && map[x][y] == map[x + 1][y + 1])
      move1(map[x][y], x + 1, y + 1, cnt + 1);
  }

  public static void move2(int t, int x, int y, int cnt) {
    if (cnt == 5) {
      System.out.print(t + "\n" + (x - 1) + " " + (y + 1));
      System.exit(0);
      return;
    }

    if (range(x + 1, y - 1) && map[x][y] == map[x + 1][y - 1])
      move2(map[x][y], x + 1, y - 1, cnt + 1);
  }

  public static boolean range(int nx, int ny) {
    return nx >= 0 && nx < 19 && ny >= 0 && ny < 19;
  }
}