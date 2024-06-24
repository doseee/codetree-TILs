import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        StringBuffer sb = new StringBuffer();
        while(true) {
            sb.append(n % b);
            n /= b;
            if (n == 0) break;
        }

        System.out.print(sb.reverse());
    }
}