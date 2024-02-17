import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    Point[] a = new Point[n];
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      a[i] = new Point(x, y);
    }

    int idx = 1, ans = Integer.MAX_VALUE;
    for (int i = 0; i < n - 2; i++) {
      int sum = 0;
      for (int j = 0; j < n - 1; j++) {
        if (j + 1 == idx) {
          sum += Math.abs(a[j].x - a[j + 2].x) + Math.abs(a[j].y - a[j + 2].y);
          j++;
        }
        else
          sum += Math.abs(a[j].x - a[j + 1].x) + Math.abs(a[j].y - a[j + 1].y);
      }
      ans = Math.min(sum, ans);
      idx++;
    }

    System.out.println(ans);
  }
}