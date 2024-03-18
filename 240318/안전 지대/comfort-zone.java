import java.util.Scanner;

public class Main {
    public static final int DIR_NUM = 4;
    public static final int MAX_HEIGHT = 100;
    public static final int MAX_M = 50;
    public static final int MAX_N = 50;
    
    public static int n, m;
    public static int[][] grid = new int[MAX_N][MAX_M];
    public static boolean[][] visited = new boolean[MAX_N][MAX_M];
    public static int zoneNum;
    
    // visited 배열을 초기화해줍니다.
    public static void initializeVisited() {
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                visited[i][j] = false;
    }
    
    // 탐색하는 위치가 격자 범위 내에 있는지 여부를 반환합니다.
    public static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
    
    // 탐색하는 위치로 움직일 수 있는지 여부를 반환합니다.
    public static boolean canGo(int x, int y, int k) {
        if(!inRange(x, y)) 
            return false;
    
        if(visited[x][y] || grid[x][y] <= k)
            return false;
    
        return true;
    }
    
    public static void DFS(int x, int y, int k) {
        //0: 오른쪽, 1: 아래쪽, 2: 왼쪽, 3: 위쪽
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        
        // 네 방향에 각각에 대하여 DFS 탐색을 합니다.
        for(int dir = 0; dir < DIR_NUM; dir++) {
            int newX = x + dx[dir];
            int newY = y + dy[dir];
    
            if(canGo(newX, newY, k)){
                visited[newX][newY] = true;
                DFS(newX, newY, k);
            }
        }
    }
    
    public static void getZoneNum(int k) {
        // 새로운 탐색을 시작한다는 의미로 zoneNum를 0으로 갱신하고 
        // visited 배열을 초기화해줍니다.
        zoneNum = 0;
        initializeVisited();
        
        // 격자의 각 위치에 대하여 탐색을 시작할 수 있는 경우
        // 해당 위치로부터 시작한 DFS 탐색을 수행합니다.
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++) {
                if(canGo(i, j, k)) {
                    // 해당 위치를 탐색할 수 있는 경우 visited 배열을 갱신하고
                    // 안전 영역을 하나 추가해줍니다.
                    visited[i][j] = true;
                    zoneNum++;
    
                    DFS(i, j, k);
                }
            }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 가능한 안전 영역의 최솟값이 0이므로 다음과 같이 초기화 해줄 수 있습니다.
        int maxZoneNum = -1; 
        int answerK = 0;

        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();

        // 각 가능한 비의 높이에 대하여 안전 영역의 수를 탐색합니다.
        for(int k = 1; k <= MAX_HEIGHT; k++){
            getZoneNum(k);

            // 기존의 최대 영역의 수보다 클 경우 이를 갱신하고 인덱스를 저장합니다.
            if(zoneNum > maxZoneNum) {
                maxZoneNum = zoneNum;
                answerK = k;
            }
        }

        System.out.print(answerK + " " + maxZoneNum);
    }
}