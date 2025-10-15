import java.util.*;

class Solution {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[][] dist;
    static int N, M;
    static int[][] maps;
    
    // 0:벽, 1:이동가능
    public int solution(int[][] maps) {
        int answer = 0;
        this.maps = maps;
        N = maps.length;
        M = maps[0].length;
        bfs();
        answer = dist[N-1][M-1];
        if(answer==0) answer = -1;
        return answer;
    }
    
    // visited 대신 dist 사용해서 최단거리 구하기
    public static void bfs(){
        dist = new int[N][M];
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {0,0});
        dist[0][0] = 1;
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            
            for(int i=0; i<4; i++){
                int nx = curr[0] + dx[i];
                int ny = curr[1] + dy[i];
                
                if(nx <0||ny <0 || nx >=N || ny >= M) continue;    // map 범위 밖
                if(maps[nx][ny] == 0) continue;    // 벽인 경우
                if(dist[nx][ny] != 0) continue; // 이미 방문한 경우
                
                q.offer(new int[] {nx, ny});
                dist[nx][ny] = dist[curr[0]][curr[1]] + 1;
            }
        }
        
        
    }
}