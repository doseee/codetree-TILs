import java.util.*;
import java.io.*;

public class Main {

  static HashSet<Character> list;
  static int[] select;
  static int ans;
  static String s;

  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    s = br.readLine();

    list = new HashSet<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (Character.isAlphabetic(c))
        list.add(c);
    }

    ans = Integer.MIN_VALUE;
    select = new int[list.size()];
    if (s.length() != 1)
      perm(0);
    else
      ans = 4;

    System.out.print(ans);
  }

  public static int cal(int x, int y, char o) {
    if (o == '-')
      return x - y;
    if (o == '+')
      return x + y;
    if (o == '*')
      return x * y;
    return x / y;
  }

  public static void calc() {
    HashMap<Character, Integer> h = new HashMap<>();
    int idx = 0;
    for (Character c : list)
      h.put(c, select[idx++]);

    int sum = cal(h.get(s.charAt(0)), h.get(s.charAt(2)), s.charAt(1));
    for (int i = 3; i < s.length() - 1; i+=2)
      sum = cal(sum, h.get(s.charAt(i + 1)), s.charAt(i));

    ans = Math.max(ans, sum);
  }

  public static void perm(int cnt) {
    if (cnt == list.size()) {
      calc();
      return;
    }

    for (int i = 1; i <= 4; i++) {
      select[cnt] = i;
      perm(cnt + 1);
    }
  }
}