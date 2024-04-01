import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    HashMap<Integer, Integer> h = new HashMap<>();
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      if (h.containsKey(x)) {
        int t = h.get(x);
        if (t > y)
          h.put(x, y);
      }
      else
        h.put(x, y);
    }

    int ans = 0;
    for (Integer i : h.values())
      ans += i;
    
    System.out.print(ans);
  }
}