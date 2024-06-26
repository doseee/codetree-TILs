import java.util.*;
import java.io.*;

public class Main {
  
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int[3];
        for (int i = 0; i < 3; i++)
            a[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(a);

        // 세 숫자가 각각 2 초과로 차이나는 경우 2만큼 차이나게 옮긴 다음 옮겨 넣으면 되기 때문에 2번이 최대
        int ans = 2;
        if (a[2] - a[1] == 2 || a[1] - a[0] == 2)
            ans = 1; // 그 두 숫자 사이에 끼우는 경우
        if (a[2] - a[1] == 1 && a[1] - a[0] == 1)
            ans = 0; // 이미 정ㄷ바인 경우
        System.out.print(ans);
    }
}