import java.util.*;
import java.io.*;
import java.util.Map.Entry;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String s = br.readLine();
    HashMap<Character, Integer> h = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      h.put(c, h.getOrDefault(c, 0) + 1);
    }

    HashSet<Character>  hs = new HashSet<>();
    for (Entry<Character, Integer> entry : h.entrySet())
      if (entry.getValue() == 1)
        hs.add(entry.getKey());

    char ans = '?';
    for (int i = 0; i < s.length(); i++) {
      if (hs.contains(s.charAt(i))) {
        ans = s.charAt(i);
        break;
      }
    }

    if (hs.isEmpty())
      System.out.print("None");
    else
      System.out.print(ans);
  }
}