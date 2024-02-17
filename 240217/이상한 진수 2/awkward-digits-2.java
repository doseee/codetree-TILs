import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String s = br.readLine();
    int max = 0;
    for (int i = 1; i < s.length(); i++) {
      StringBuilder sb = new StringBuilder(s);
      char c = s.charAt(i);
      c = c == '0' ? '1': '0';
      sb.setCharAt(i, c);
      int x = Integer.parseInt(sb.toString(), 2);
      max = Math.max(max, x);
    }

    System.out.print(max);
  }
}