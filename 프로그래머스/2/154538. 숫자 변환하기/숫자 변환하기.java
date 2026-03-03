import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        if(x == y) return 0;
        
        int[] dist = new int[y+1];
        Arrays.fill(dist, -1);  // x를 y로 만들 수 없다면 -1 리턴
        
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(x);
        dist[x] = 0;
        
        while(!q.isEmpty()){
            int cur = q.poll();
            
            // x를 y로 만든 경우
            if(cur == y){
                return dist[cur];
            }
            
            int[] next = new int[]{cur+n, cur*2, cur*3};
            for(int nt : next){
                // 넘어가는 조건들
                if(nt > y) continue;
                if(dist[nt] != -1) continue;    // 이미 방문한 경우
                
                q.offer(nt);
                dist[nt] = dist[cur] + 1;
            }
        }
        
        return -1;
    }
}