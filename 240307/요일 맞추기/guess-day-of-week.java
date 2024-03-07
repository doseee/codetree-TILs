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

    int[] month = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    String[] day = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};

    int sum = 0;
    if (m1 < m2) {
      sum += month[m1] - d1;
      for (int i = m1 + 1; i < m2; i++)
        sum += month[i];
      sum += d2;
    }
    else if (m1 > m2) {
      sum -= month[m2] - d2;
      for (int i = m2 + 1; i < m1; i++)
        sum -= month[i];
      sum -= d1;
    }
    else {
      if (d1 < d2)
        sum += d2 - d1;
      else
        sum -= d1 - d2;
    }

    if (sum > 0)
      System.out.print(day[sum % 7]);
    else
      System.out.print(day[(sum  + 7)% 7]);
  }
}