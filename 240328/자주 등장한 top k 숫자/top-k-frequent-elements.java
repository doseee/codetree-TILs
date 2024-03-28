import java.awt.Point;
import java.util.*;
import java.io.*;
import java.util.Map.Entry;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    HashMap<Integer, Integer> m = new HashMap<>();
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      int x = Integer.parseInt(st.nextToken());
      m.put(x, m.getOrDefault(x, 0) + 1);
    }

    Point[] list = new Point[m.size()];
    int idx = 0;
    for (Entry<Integer, Integer> entry : m.entrySet()) {
      list[idx++] = new Point(entry.getKey(), entry.getValue());
    }

    Arrays.sort(list, new Comparator<Point>() {
      @Override
      public int compare(Point o1, Point o2) {
        if (o2.y == o1.y)
          return o2.x - o1.x;
        return o2.y - o1.y;
      }
    });
    
    for (int i = 0; i < k; i++) {
      System.out.print(list[i].x + " ");
    }
  }

}