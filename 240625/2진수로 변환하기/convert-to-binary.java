import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String s = "";
        while(true) {
            s += n % 2;
            n /= 2;
            if (n == 0) break;
        }
        for (int i = s.length() - 1; i>=0; i--)
            System.out.print(s.charAt(i));
    }
}