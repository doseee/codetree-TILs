import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

   int n = Integer.parseInt(br.readLine());
   
   HashMap<String, Integer> h = new HashMap<>();
   int max = 0;
   for (int i = 0; i < n; i++) {
      String s = br.readLine();
      h.put(s, h.getOrDefault(s, 0) + 1);
      max = Math.max(max, h.get(s));
   }

   System.out.print(max);
  }
}