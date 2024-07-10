import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {
  
  static int n, m, ans, t;
  static int[] select, two;
  static Point[] list;

  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    list = new Point[n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      list[i] = new Point(x, y);
    }

    ans = Integer.MAX_VALUE;
    select = new int[m];
    two = new int[2];
    comb(0, 0);

    System.out.print(ans);
  }

  public static void choice(int cnt, int idx) {
    if (cnt == 2) {
      Point p1 = list[two[0]], p2 = list[two[1]];
      int x = p1.x - p2.x, y = p1.y - p2.y;
      x *= x; y *= y;
      t = Math.max(t, x + y);
      return;
    }

    for (int i = idx; i < m; i++) {
      two[cnt] = select[i];
      choice(cnt + 1, i + 1);
    }
  }

  public static void comb(int cnt, int idx) {
    if (cnt == m) {
      t = 0;
      choice(0, 0);
      ans = Math.min(ans, t);
      return;
    }

    for (int i = idx; i < n; i++) {
      select[cnt] = i;
      comb(cnt + 1, i + 1);
    }

  }
}