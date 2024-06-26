import java.util.*;
import java.io.*;

public class Main {
    
    static int ans;
  
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        ans = Integer.MAX_VALUE;
        dfs(a, b, c, 0);

        System.out.print(ans);
    }

    public static void dfs(int a, int b, int c, int cnt) {
        if (a == b || b == c || a == c) return;
        if (c - b == 1 && b - a == 1) {
            ans = Math.min(cnt, ans);
            return;
        }

        //a를 옮기는 경우
        if ((c - b <= b - a && c - b != 1) || b - a == 1) {
                dfs(b, (b + c) / 2, c, cnt + 1);
        }
        if ((c - b > b - a && b - a != 1)|| c - b == 1) {
            //c를 옮기는 경우
                dfs(a, (a + b) / 2, b, cnt + 1);
        }
    }
}