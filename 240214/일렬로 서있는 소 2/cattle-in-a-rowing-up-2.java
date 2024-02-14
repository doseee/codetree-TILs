import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    int[] a = new int[n];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++)
      a[i] = Integer.parseInt(st.nextToken());

    int ans = 0;
    for (int i = 0; i < n - 2; i++)
      for (int j = i + 1; j < n - 1; j++)
       for (int k = j + 1; k < n; k++)
         if ((i < j) && (j < k) &&(a[i] <= a[j]) && (a[j] <= a[k]))
           ans++;
    
    System.out.print(ans);
  }
}