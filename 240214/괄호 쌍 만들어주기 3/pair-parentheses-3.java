import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String s = br.readLine();

    int ans = 0;
    for (int i = 0; i < s.length() - 1; i++) {
      char c = s.charAt(i);
      for (int j = i + 1; j < s.length(); j++)
        if (c == '(' && s.charAt(j) == ')')
          ans++;
    }

    System.out.print(ans);
  }
}