import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[] a = new int[n];
        int total = 0;
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
            total += a[i];
        }

        total /= n;
        int ans = 0;
        for (int i = 0; i < n; i++)
            if (a[i] > total)
                ans += a[i] - total;

        System.out.print(ans);
    }
}