import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int ans = Math.abs(a - b);
        
        int cnt = Math.abs(a - x) + Math.abs(y - b);
        ans = Math.min(cnt, ans);
        cnt = Math.abs(a - y) + Math.abs(x - b);
        ans = Math.min(cnt, ans);

        System.out.print(ans);
    }
}