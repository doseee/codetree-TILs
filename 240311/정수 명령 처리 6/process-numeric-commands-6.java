import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));
    int n = Integer.parseInt(br.readLine());

    PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o2 - o1;
      }
    });
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      String s = st.nextToken();
      if (s.equals("push"))
        q.add(Integer.parseInt(st.nextToken()));
      else if (s.equals("size"))
        sb.append(q.size() + "\n");
      else if (s.equals("pop"))
        sb.append(q.poll() + "\n");
      else if (s.equals("top"))
        sb.append(q.peek() + "\n");
      else {
        if (q.isEmpty())
          sb.append(1 + "\n");
        else
          sb.append(0 + "\n");
      }
    }

    bw.write(sb.toString());
    bw.close(); br.close();
  }
}