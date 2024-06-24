import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringBuffer s = new StringBuffer();
        while(true) {
            s.append(n % 2);
            n /= 2;
            if (n == 0) break;
        }
       System.out.println(s.reverse());
    }
}