import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
                a[i][j] = Integer.parseInt(st.nextToken());
        }


        List<Point> ans = new ArrayList<>();
        int num = 0;
        for (int i = 0; i < n; i++) {
            ex:for (int j = 0; j <= n - m; j++) {
                Integer[] t = new Integer[m];
                int idx = 0;
                for (int k = j; k < j + m; k++)
                    t[idx++] = a[i][k];

                Arrays.sort(t, Collections.reverseOrder());

                int chk = 0, sum = 0;
                for (int k = 0; k < m; k++) {
                    if (chk + t[k] <= c) {
                        chk += t[k];
                        sum += t[k] * t[k];
                    }
                }
                ans.add(new Point(sum, num++));
            }
            num++;
        }

        Collections.sort(ans, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if (o2.x == o1.x)
                    return o1.y - o2.y;
                return o2.x - o1.x;
            }
        });

        int rslt = ans.get(0).x;
        int t = ans.get(0).y;
        for (int i = 1; i < ans.size(); i++) {
            if (Math.abs(t - ans.get(i).y) >= m) {
                rslt += ans.get(i).x;
                break;
            }
        }
        System.out.print(rslt);
    }
}