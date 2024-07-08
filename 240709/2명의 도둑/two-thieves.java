import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {
    
    static int m, c, num;
    static int[] t;
    static boolean[] select;
    static List<Point> ans;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
                a[i][j] = Integer.parseInt(st.nextToken());
        }


        ans = new ArrayList<>();
        num = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n - m; j++) {
                t = new int[m];
                int idx = 0;
                for (int k = j; k < j + m; k++)
                    t[idx++] = a[i][k];

                select = new boolean[m];
                subset(0);
            }
            num+=n;
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
            if (Math.abs(t - ans.get(i).y) >= Math.pow(m, 2)) {
                rslt += ans.get(i).x;
                break;
            }
        }
        System.out.print(rslt);
    }

    public static void subset(int cnt) {
        if (cnt == m) {
            int chk = 0, sum = 0;
            for (int i = 0; i < m; i++) {
                if (select[i]) {
                    if (chk + t[i] <= c) {
                        chk += t[i];
                        sum += t[i] * t[i];
                    }
                }
            }
            ans.add(new Point(sum, num++));
            return;
        }

        select[cnt] = true;
        subset(cnt + 1);
        select[cnt] = false;
        subset(cnt + 1);
    }
}