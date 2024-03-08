import java.util.*;
import java.io.*;
import java.util.Map.Entry;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    HashMap<Integer, Integer> h = new HashMap<>();
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      int x = Integer.parseInt(st.nextToken());
      h.put(x, h.getOrDefault(x, 0) + 1);
    }

    int ans = 0;
    if (h.size() == 1) {
      for (Entry<Integer, Integer> e : h.entrySet()) {
        int x = e.getValue();
        if (e.getKey() * 2 == k && x > 1)
          ans += (x * (x - 1));
      }
    }
    for (Entry<Integer, Integer> e1 : h.entrySet()) {
      for (Entry<Integer, Integer> e2 : h.entrySet()) {
        if (e1.getKey() != e2.getKey()) {
         int sum = e1.getKey() + e2.getKey();
         if (sum == k)
           ans += e1.getValue() * e2.getValue();
        }
      }
    }

    System.out.print(ans / 2);
  }
}