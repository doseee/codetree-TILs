import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int idx = 1;
        int ans = s.charAt(s.length() - 1) - '0';

        for (int i = s.length() - 2; i >= 0; i--) {
            int x = s.charAt(i) - '0';
            ans += x * Math.pow(2, idx);
            idx++;
        }
        
        System.out.print(ans);
    }
}