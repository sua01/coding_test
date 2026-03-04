import java.util.*;

class Solution {
    // 네트워크 개수 반환하기
    static boolean visited[];
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        visited = new boolean[n];
        for(int i=0; i<n ;i++){
            if(!visited[i]){
                // 방문하지 않은 경우 bfs 탐색
                bfs(i, n, computers);
                answer++;
            }
        }
        
        return answer;
    }
    
    public static void bfs(int start, int n, int[][] computers){
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(start);
        visited[start] = true;
        
        while(!q.isEmpty()){
            int cur = q.poll();
            
            for(int i=0; i<n; i++){
                if(computers[cur][i] == 1 && !visited[i]){
                    q.offer(i);
                    visited[i] = true;
                }
            }
            
            
        }
    }
}