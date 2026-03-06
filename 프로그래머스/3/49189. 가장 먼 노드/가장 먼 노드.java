import java.util.*;

class Solution {
    static int[] dist;
    static ArrayList<Integer>[] graph; 
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        // 그래프 만들기
        graph = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] e: edge){
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        
        // 1번 노드부터 bfs 돌려서 최단거리 구하기
        dist = new int[n+1];
        bfs(1);
        
        // 가장 멀리 떨어져 있는 노드 개수 구하기
        int max = Integer.MIN_VALUE;
        for(int i=1; i<=n;i++){
            if(dist[i] >= max) max = dist[i];
        }
        
        for(int i=1; i<=n;i++){
            if(dist[i] == max) answer++;
        }
        
        return answer;
    }
    
    public static void bfs(int start){
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(start);
        dist[start] = 1;
        
        while(!q.isEmpty()){
            int cur = q.poll();
            
            for(int next : graph[cur]){
                if(dist[next] != 0) continue;
                q.offer(next);
                dist[next] = dist[cur] + 1;
            }
        }
    }
}