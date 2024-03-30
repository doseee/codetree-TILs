import java.util.*;
import java.io.*;


public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    HashMap<String, Integer> h = new HashMap<>();
    for (int i = 0; i < n; i++) {
      String t = br.readLine();
      char[] ch = t.toCharArray();
      Arrays.sort(ch);
      t = new String(ch);
      h.put(t, h.getOrDefault(t, 0) + 1);
    }

    int ans = 0;
    for (Integer i : h.values())
      ans = Math.max(ans, i);

    System.out.print(ans);
  }
}