import java.util.*;

class Solution {
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static int[][] time;  // 필요한 시간 저장
    static int N, M;
    public int solution(String[] maps) {
        N = maps.length;
        M = maps[0].length();
        time = new int[N][M];
        
        
        // 시작, 출구, 레버 좌표 위치 찾기
        int[] s = {}, e={}, l={};
        for(int i=0; i<N; i++){
            for(int j =0; j<M; j++){
                if(maps[i].charAt(j) == 'S'){
                    s = new int[]{i, j};
                }
                else if(maps[i].charAt(j) == 'E'){
                    e = new int[]{i, j};
                }
                else if(maps[i].charAt(j) == 'L'){
                    l = new int[]{i, j};
                }
            }
        }
        
        
        // 시작 > 레버 가는 최소 시간
        int sl = bfs(maps, s, l);
        
        if(sl == -1) return -1;
        
        // 레버 > 출구 가는 최소 시간
        int le = bfs(maps, l, e);
        if(le == -1) return -1;
        
        return sl + le;
        
    }
    
    public static int bfs(String[] maps, int[] start, int[]end){
        for(int i = 0; i < N; i++){
            Arrays.fill(time[i], -1);
        }
        ArrayDeque<int[]> q = new ArrayDeque<>();
        time[start[0]][start[1]] = 0;
        q.offer(start);
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            if(cur[0] == end[0] && cur[1] == end[1]){
                // 목적지 도착
                return time[cur[0]][cur[1]];
            }
            
            for(int i=0; i<4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                
                if(nx < 0 || nx >= N || ny <0 || ny>=M) continue;   // map 범위 넘어간 경우
                if(time[nx][ny] != -1) continue; // 이미 방문한 경우
                if(maps[nx].charAt(ny) == 'X') continue;   // 벽인 경우
                
                q.offer(new int[]{nx, ny});
                time[nx][ny] = time[cur[0]][cur[1]] + 1;
                
            }
        }
        
        return -1;  // 최단 경로 없는 경우
    }
}