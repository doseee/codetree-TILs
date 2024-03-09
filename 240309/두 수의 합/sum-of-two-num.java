import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    long[] a = new long[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      long x = Long.parseLong(st.nextToken());
      a[i] = x;
    }

    int ans = 0;
    HashMap<Long, Long> h = new HashMap<>();
    for (int i = 0; i < n; i++) {
     long x = k - a[i];

     if (h.containsKey(x))
       ans += h.get(x);

      h.put(a[i], h.getOrDefault(a[i], Long.valueOf(0)) + 1);
    }

    System.out.print(ans);
  }
}