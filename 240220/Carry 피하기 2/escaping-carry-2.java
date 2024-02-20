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
    int[] t = new int[3];
    for (int i = 0; i < 3; i++)
      t[i] = select[i];

    while (true) {
      int sum = 0;
      for (int i = 0; i < 3; i++)
        sum += t[i] % 10;

      if (sum >= 10) return;

      int cnt = 0;
      for (int i = 0; i < 3; i++) {
        t[i] /= 10;
        if (t[i] == 0)
          cnt++;
      }

      if (cnt == 3) break;
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