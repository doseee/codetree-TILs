import java.io.*;

public class Main {

  static String s;
  static int ans;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    s = br.readLine();
    ans = 0;

    for (int i = 0; i < s.length() - 2; i++) {
      String t = s.substring(i, i + 2);
      if (t.equals("(("))
        dfs(i + 2);
    }

    System.out.print(ans);
  }

  public static void dfs(int idx) {
   for (int i = idx; i < s.length() - 1; i++) {
     String t = s.substring(i, i + 2);
     if (t.equals("))"))
       ans++;
   }
  }
}