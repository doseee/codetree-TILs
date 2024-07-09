import java.util.*;
import java.io.*;

public class Main {

    static List<Integer> x, y;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        Point[] list = new Point[a];
        for (int i = 0; i < a; i++) {
            st = new StringTokenizer(br.readLine());
            char c = st.nextToken().charAt(0);
            int n = Integer.parseInt(st.nextToken());
            list[i] = new Point(c, n);
        }

        x = calc(list);
        
        list = new Point[b];
        for (int i = 0; i < b; i++) {
            st = new StringTokenizer(br.readLine());
            char c = st.nextToken().charAt(0);
            int n = Integer.parseInt(st.nextToken());
            list[i] = new Point(c, n);
        }

        y = calc(list);

        int ans = -1;
        int size = Math.min(x.size(), y.size());
        for (int i = 0; i < size; i++) {
            if (x.get(i) == y.get(i)) {
                ans = i;
                break;
            }
        }

        System.out.print(ans + 1);
    }

    public static List<Integer> calc(Point[] list) {
        List<Integer> t = new ArrayList<>();

        int idx = 0;
        for (int i = 0; i < list.length; i++) {
            Point p = list[i];
            int l = -1;
            if (p.c == 'R')
                l = 1;
            for (int j = 0; j < p.n; j++) {
                idx += l;
                t.add(idx);
            }
        }

        return t;
    }

    static class Point {
        char c;
        int n;

        public Point(char c, int n) {
            this.c = c;
            this.n = n;
        }
    }
}