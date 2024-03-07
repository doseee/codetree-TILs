import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    HashMap<Integer, Integer> h = new HashMap<>();
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      int x = Integer.parseInt(st.nextToken());
      h.put(x, h.getOrDefault(x, 0) + 1);
    }

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < m; i++) {
      int x = Integer.parseInt(st.nextToken());
      if (h.containsKey(x))
        System.out.print(h.get(x) + " ");
      else
        System.out.print(0 + " ");
    }
  }
}