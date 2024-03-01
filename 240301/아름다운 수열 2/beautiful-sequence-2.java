import java.util.*;
import java.io.*;
import java.util.Map.Entry;

public class Main {

 public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    int[] a = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++)
      a[i] = Integer.parseInt(st.nextToken());

    HashMap<Integer, Integer> h = new HashMap<>();
    st = new StringTokenizer(br.readLine());
    while (st.hasMoreTokens()) {
      int x = Integer.parseInt(st.nextToken());
      h.put(x, h.getOrDefault(x, 0) + 1);
    }

    int ans = 0;
    for (int i = 0; i < n - m + 1; i++) {
      HashMap<Integer, Integer> t = new HashMap<>();
      for (int j = i; j < i + m; j++) {
        int x = a[j];
        t.put(x, t.getOrDefault(x, 0) + 1);
      }
      
      if (h.size() != t.size()) continue;

      int cnt = 0;
      for (Entry<Integer, Integer> entry : h.entrySet()) {
        int x = entry.getKey();
        int y = entry.getValue();
        if (!t.containsKey(x)) continue;
        
        if (t.get(x) == y)
          cnt++;
      }
      
      if (cnt == h.size())
        ans++;
    }

    System.out.print(ans);
  }
}