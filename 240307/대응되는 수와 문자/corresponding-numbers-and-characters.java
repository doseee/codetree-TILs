import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    HashMap<String, Integer> h1 = new HashMap<>();
    HashMap<Integer, String> h2 = new HashMap<>();
    for (int i = 1; i <= n; i++) {
      String s = br.readLine();
      h1.put(s, i);
      h2.put(i, s);
    }

    for (int i = 0; i < m; i++) {
      String s = br.readLine();
      Character c = s.charAt(0);
      if (Character.isDigit(c))
        System.out.println(h2.get(c - '0'));
      else
        System.out.println(h1.get(s));
    }
  }
}