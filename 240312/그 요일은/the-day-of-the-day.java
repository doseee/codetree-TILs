import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int m1 = Integer.parseInt(st.nextToken());
    int d1 = Integer.parseInt(st.nextToken());
    int m2 = Integer.parseInt(st.nextToken());
    int d2 = Integer.parseInt(st.nextToken());

    String a = br.readLine();

    String[] d = {"", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
    int[] m = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    int sum = m[m1] - d1;
    for (int i = m1 + 1; i < m2; i++)
      sum += m[i];

    sum += d2;

    int idx = 0;
    for (int i = 1; i <= 7; i++) {
      if (d[i].equals(a)) {
        idx = i;
        break;
      }
    }
    
    System.out.print(((sum - idx + 1) / 7) + 1);
  }
}