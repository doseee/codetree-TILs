import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    
    HashMap<String, Integer> h = new HashMap<>();
    String[] str = new String[n + 1];
    for (int i = 1; i <= n; i++) {
      String s = br.readLine();
      h.put(s, i);
      str[i] = s;
    }

    for (int i = 0; i < m; i++) {
      String s = br.readLine();
      char c = s.charAt(0);
      if (Character.isDigit(c))
        System.out.println(str[Integer.parseInt(s)]);
      else
        System.out.println(h.get(s));
    }
  }
}