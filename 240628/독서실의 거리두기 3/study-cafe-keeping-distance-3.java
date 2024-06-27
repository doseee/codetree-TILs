import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int ans = Integer.MAX_VALUE, t = 0, idx = 0;
        HashSet<Integer> h = new HashSet<>();
        for (int i = 1; i < s.length() - 1; i++) {
            if (s.charAt(i) == '1') {
                if (ans > i - t) {
                    ans = i - t;
                    idx = i;
                }
                t = i;
            }

            if (s.charAt(i - 1) == s.charAt(i + 1) && s.charAt(i) == '0' && s.charAt(i + 1) == '0') {
                h.add(i);
            }
        }

        if (h.size() != 1 && ans != 1) {
            ans /= 2;
        }

        System.out.print(ans);
    }
}