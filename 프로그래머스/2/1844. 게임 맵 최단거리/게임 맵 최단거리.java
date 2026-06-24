import java.util.*;

class Solution {
    static int[] dx = {-1, 1, 0,0};
    static int[] dy = {0, 0, -1,1};
    
    public int solution(int[][] maps) {
        int answer = -1;
        int n = maps.length;
        int m = maps[0].length;
        
        int[][] dist = new int[n][m];   // 최단거리 저장
        ArrayDeque<int[]> q = new ArrayDeque<>();
        
        // bfs
        q.offer(new int[] {0,0});
        dist[0][0] = 1;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            // 최단거리 리턴
            if(cur[0] == n-1 && cur[1] == m-1) return  dist[cur[0]][cur[1]];
            
            for(int i=0; i<4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                
                if(nx < 0 || nx > n-1 || ny <0 || ny >m-1) continue;
                if(maps[nx][ny] == 0) continue;
                if(dist[nx][ny] != 0) continue;
                
                dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
                q.offer(new int[] {nx, ny});
            }
        }
        
        
        return answer;
    }
}