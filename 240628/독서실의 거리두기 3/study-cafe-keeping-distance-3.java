import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int t = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < n - 1; i++) {
            if (s.charAt(i) == '1') {
                list.add(i - t);
                t = i;
            }
        }

        Collections.sort(list);
        int ans = list.get(0);
        for (Integer i : list) {
            if (i >= 4) {
                if (i / 2 < ans)
                    ans = i / 2;
                break;
            }
        }
        System.out.print(ans);
    }
}