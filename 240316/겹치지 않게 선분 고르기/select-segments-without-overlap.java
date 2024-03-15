import com.sun.org.apache.xerces.internal.dom.PSVIElementNSImpl;
import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {

  static int[] select;
  static Point[] a;
  static int ans, n;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());
    a = new Point[n];
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      a[i] = new Point(x, y);
    }

    ans = 0;
    for (int i = n; i >= 1; i--) {
      select = new int[i];
      perm(0, 0, i);
      if (ans != 0) {
        ans = i;
        break;
      }
    }

    System.out.print(ans);
  }

  public static void perm(int cnt, int idx, int d) {
    if (cnt == d) {
      int[] l = new int[1001];
      for (int i = 0; i < d; i++) {
        Point p = a[select[i]];
        for (int j = p.x; j <= p.y; j++)
          if (l[j] == 0)
            l[j] = 1;
          else
            return;
      }

      ans = 1;
      return;
    }

    for (int i = idx; i < n; i++) {
      select[cnt] = i;
      perm(cnt + 1, i + 1, d);
    }
  }
}