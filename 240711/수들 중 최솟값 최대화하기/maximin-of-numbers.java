import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {

  static int n, ans;
  static int[] select;
  static boolean[] visit;
  static int[][] map;
  static Point[] list;

  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());

    int idx = 0;
    list = new Point[n * n];
    map = new int[n][n];
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        list[idx++] = new Point(i, j);
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    ans = 0;
    select = new int[n];
    visit = new boolean[n * n];
    perm(0, 0);

    System.out.print(ans);
  }

  public static boolean check() {
    HashSet<Integer> x = new HashSet<>();
    HashSet<Integer> y = new HashSet<>();

    for (int i = 0; i < n; i++) {
      Point p = list[select[i]];
      x.add(p.x);
      y.add(p.y);
    }

    if (x.size() == n && y.size() == n)
      return true;

    return false;
  }

  public static void calc() {
    int min = Integer.MAX_VALUE;

    for (int i = 0; i < n; i++) {
      Point p = list[select[i]];
      min = Math.min(min, map[p.x][p.y]);
    }

    ans = Math.max(ans, min);
  }

  public static void perm(int cnt, int bitMask) {
        if (cnt == n) {
            if (check()) calc();
            return;
        }

        for (int i = 0; i < n * n; i++) {
            if ((bitMask & (1 << i)) == 0) {
                select[cnt] = i;
                perm(cnt + 1, bitMask | (1 << i));
            }
        }
  }
}