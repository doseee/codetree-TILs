import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    int[] arr = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++)
      arr[i] = Integer.parseInt(st.nextToken());

    int ans = 0;
    for (int i = 0; i < n - 2; i++) {
      int x = k - arr[i];
      HashMap<Integer, Integer> h = new HashMap<>();
      for (int j = i + 1; j < n; j++) {
        int y = x - arr[j];
        if (h.containsKey(y))
          ans += h.get(y);
        h.put(arr[j], h.getOrDefault(arr[j], 0) + 1);
      }
    }

    System.out.print(ans);
  }
}