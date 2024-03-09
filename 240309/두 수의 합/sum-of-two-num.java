import java.util.*;
import java.io.*;
import java.util.Map.Entry;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    HashMap<Long, Long> h = new HashMap<>();
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      Long x = Long.parseLong(st.nextToken());
      h.put(x, h.getOrDefault(x, Long.valueOf(0)) + 1);
    }

    int ans = 0;
    for (Entry<Long, Long> e : h.entrySet()) {
      Long x = e.getKey();
      Long y = k - x;
      if (h.containsKey(y)) {
        ans += ((e.getValue() * (e.getValue() - 1)) / 2);
        ans += ((h.get(y) * (h.get(y) - 1)) / 2);
      }
    }

    System.out.print(ans / 2);
  }
}