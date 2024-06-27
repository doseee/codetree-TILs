import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int t = 0, ans = Integer.MAX_VALUE, dist = 0;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == '1') {
                ans = Math.min(ans, i - t);
                dist = Math.max(dist, i - t);
                t = i;
            }
        }

        if (dist / 2 < ans)
            ans = dist / 2;
         
        System.out.print(ans);
    }
}