import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    String s = br.readLine();

    int ans = 0;
    for (int i = 0; i < n; i++)
      if (s.charAt(i) == 'C')
        for (int j = i + 1; j < n; j++)
          if (s.charAt(j) == 'O')
            for (int k = j + 1; k < n; k++)
              if (s.charAt(k) == 'W')
                ans++;
    
    System.out.print(ans);
  }
}