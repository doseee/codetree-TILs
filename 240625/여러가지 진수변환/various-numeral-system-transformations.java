import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<Integer>();
        while(true) {
            list.add(n % b);
            n /= b;
            if (n == 0) break;
        }

        Collections.reverse(list);
        String s  = "";
        for (Integer i : list)
            s+= i;
        System.out.print(s);
    }
}