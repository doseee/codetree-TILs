import java.io.*;

public class Main {

  static int n, ans;
  static int[] a, select;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());
    a = new int[n];
    for (int i = 0; i < n; i++)
      a[i] = Integer.parseInt(br.readLine());

    select = new int[3];
    ans = -1;
    comb(0, 0);

    System.out.print(ans);
  }

  public static void calc() {
    String s1 = Integer.toString(select[0]);
    String s2 = Integer.toString(select[1]);
    String s3 = Integer.toString(select[2]);

    int idx = 0;
    while (true) {
      int sum = 0;
      if (s1.length() - 1 - idx < 0) break;
      sum += s1.charAt(s1.length() - 1 - idx) - '0';
      if (s2.length() - 1 - idx < 0) break;
      sum += s2.charAt(s2.length() - 1 - idx) - '0';
      if (s3.length() - 1 - idx < 0) break;
      sum += s3.charAt(s3.length() - 1 - idx) - '0';
      idx++;
      if (sum > 10) return;
    }

    ans = Math.max(ans, select[0] + select[1] + select[2]);
  }

  public static void comb(int idx, int cnt) {
    if (cnt == 3) {
      calc();
      return;
    }

    for (int i = idx; i < n; i++) {
      select[cnt] = a[i];
      comb(i + 1, cnt + 1);
    }
  }
}