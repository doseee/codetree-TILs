import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    Point[] cs = new Point[n];
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      cs[i] = new Point(x, y);
    }

    HashSet<Point> h1 = new HashSet<>();
    h1.add(new Point(3, 2));
    h1.add(new Point(2, 1));
    h1.add(new Point(1, 3));

    HashSet<Point> h2 = new HashSet<>();
    h2.add(new Point(1, 2));
    h2.add(new Point(2, 3));
    h2.add(new Point(3, 1));

    HashSet<Point> h3 = new HashSet<>();
    h3.add(new Point(2, 1));
    h3.add(new Point(3, 2));
    h3.add(new Point(1, 3));


    int c1 = 0, c2 = 0, c3 = 0;
    for (int i = 0; i < n; i++) {
      if (h1.contains(cs[i]))
        c1++;

      if (h2.contains(cs[i]))
        c2++;

      if (h3.contains(cs[i]))
        c3++;
    }

    int ans = c1;
    if (ans < c2)
      ans = c2;
    if (ans < c3)
      ans = c3;

    System.out.print(ans);
  }
}