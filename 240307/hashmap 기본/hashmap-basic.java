import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    HashMap<Integer, Integer> h = new HashMap<>();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      String s = st.nextToken();
      int x = Integer.parseInt(st.nextToken());
      if (s.equals("add")) {
        int y = Integer.parseInt(st.nextToken());
        h.put(x, y);
      }
      else if (s.equals("find")) {
        if (h.containsKey(x))
          sb.append(h.get(x) + "\n");
        else
          sb.append("None\n");
      }
      else
        h.remove(x);
    }

    bw.write(sb.toString());
    bw.close(); br.close();
  }
}