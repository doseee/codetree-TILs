import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    int ans = 0;
    Point[] a = new Point[n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      char c = st.nextToken().charAt(0);
      int y = c == 'G' ? 1 : 2;
      a[i] = new Point(x, y);
      ans = Math.max(ans, y);
    }

    Arrays.sort(a, new Comparator<Point>() {
      @Override
      public int compare(Point o1, Point o2) {
        return o1.x - o2.x;
      }
    });

    for (int i = n - 1; i >= 0; i--) {
      for (int j = i - 1; j >= 0; j--) {
        int sum = 0;
        if (a[i].x - a[j].x <= k) {
          for (int q = j; q <= i; q++)
            sum += a[q].y;
          ans = Math.max(ans, sum);
        }
      }
    }

   System.out.print(ans);
  }
}