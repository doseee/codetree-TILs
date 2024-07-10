import java.util.*;
import java.io.*;

public class Main {

  static int n, ans;
  static int[][] map;

  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());
    map = new int[n][n];
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++)
        map[i][j] = Integer.parseInt(st.nextToken());
    }

    ans = 0;
    for (int i = 0; i < n; i++) {
      boolean[] visit = new boolean[n];
      visit[i] = true;
      int[] select = new int[n];
      select[0] = i;
      dfs(select, visit, 1);
    }

    System.out.print(ans);
  }

  public static void dfs(int[] select, boolean[] visit, int d) {
    if (d == n) {
      int min = Integer.MAX_VALUE;
      
      for (int i = 0; i < n; i++)
        min = Math.min(min, map[i][select[i]]);
        
      ans = Math.max(ans, min);
      return;
    }

    for (int i = 0; i < n; i++) {
      if (!visit[i]) {
        select[d] = i;
        visit[i] = true;
        dfs(select, visit, d + 1);
        visit[i] = false;
      }
    }
  }
}