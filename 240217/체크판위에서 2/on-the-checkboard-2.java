import java.util.*;
import java.io.*;

public class Main {

  static char[][] a;
  static int n, c, cnt;

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());

    a = new char[n][c];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < c; j++)
        a[i][j] = st.nextToken().charAt(0);
    }

    cnt = 0;
    dfs(0, 0, 1);

    System.out.print(cnt);
  }

  public static void dfs(int x, int y, int d) {
    if (d == 4 && x == n - 1 && y == c - 1) {
      cnt++;
      return;
    }

    char ch = a[x][y];
    for (int i = x + 1; i < n; i++)
      for (int j = y + 1; j < c; j++)
        if (a[i][j] != ch)
          dfs(i, j, d + 1);
    
  }

}