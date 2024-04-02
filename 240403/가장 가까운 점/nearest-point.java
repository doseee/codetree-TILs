import java.awt.Point;
import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    PriorityQueue<Point> q = new PriorityQueue<>(new Comparator<Point>() {
      @Override
      public int compare(Point o1, Point o2) {
        int x = Math.abs(o1.x) + Math.abs(o1.y);
        int y = Math.abs(o2.x) + Math.abs(o2.y);
        if (x == y) {
          if (o1.x == o2.x)
            return o1.y - o2.y;
          return o1.x - o2.x;
        }
        else {
          if (x > y)
            return o2.x - o1.x;
          else
            return o1.x - o2.x;
        }
      }
    });

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      q.add(new Point(x, y));
    }

    for (int i = 0; i < m; i++) {
      Point p = q.poll();
      System.out.println(p.x + " " + p.y);
      q.add(new Point(p.x + 2, p.y + 2));
    }

    Point ans = q.poll();
    System.out.print(ans.x + " " + ans.y);
  }
}