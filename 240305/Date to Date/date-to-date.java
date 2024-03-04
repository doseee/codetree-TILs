import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int[] m = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());
    int d = Integer.parseInt(st.nextToken());

    int ans = 1;
    while(true) {
      if (a != c) {
        ans += m[a] - b;
        b = 0;
        a++;
      }
      else {
        ans += d - b;
        break;
      }
    }

    System.out.print(ans);
  }
}