import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

class Pair { 
    int x, y;
    public Pair(int x, int y) { 
        this.x = x; 
        this.y = y; 
    } 
}

public class Main {
    public static final int DIR_NUM = 4;
    public static final int MAX_N = 100;
    
    // 전역 변수 선언:
    public static int n, k;
    public static int[][] grid = new int[MAX_N][MAX_N];
    
    // bfs에 필요한 변수들 입니다.
    public static Queue<Pair> bfsQ = new LinkedList<>();
    public static boolean[][] visited = new boolean[MAX_N][MAX_N];
    
    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }
    
    public static boolean canGo(int x, int y) {
        return inRange(x, y) && grid[x][y] == 0 && !visited[x][y];
    }
    
    public static void BFS() {
        // queue에 남은 것이 없을때까지 반복합니다.
        while(!bfsQ.isEmpty()) {
            // queue에서 가장 먼저 들어온 원소를 뺍니다.
            Pair currPos = bfsQ.poll();
            int x = currPos.x, y = currPos.y;
    
            int[] dx = new int[]{1, -1, 0, 0};
            int[] dy = new int[]{0, 0, 1, -1};
    
            // queue에서 뺀 원소의 위치를 기준으로 4방향을 확인해봅니다.
            for(int dir = 0; dir < DIR_NUM; dir++) {
                int nx = x + dx[dir], ny = y + dy[dir];
    
                // 아직 방문한 적이 없으면서 갈 수 있는 곳이라면
                // 새로 queue에 넣어주고 방문 여부를 표시해줍니다. 
                if(canGo(nx, ny)){
                    bfsQ.add(new Pair(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }
    
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력:
        n = sc.nextInt();
        k = sc.nextInt();

        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        
        // 시작점을 모두 bfs queue에 넣습니다.
        while(k-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            bfsQ.add(new Pair(x - 1, y - 1));
            visited[x - 1][y - 1] = true;
        }
        
        // bfs를 진행합니다.
        BFS();

        int ans = 0;
        
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                if(visited[i][j])
                    ans++;
        
        System.out.print(ans);
    }
}