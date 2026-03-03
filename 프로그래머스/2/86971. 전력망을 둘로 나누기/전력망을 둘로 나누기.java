import java.util.*;

class Solution {
    static ArrayList<Integer>[] tree;
    static boolean visited[];
    
    public int solution(int n, int[][] wires) {
        int min = Integer.MAX_VALUE;    // 최솟값 구하기
        
        // 트리 구성하기
        tree = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            tree[i] = new ArrayList<>();
        }
        for(int[] w : wires){
            // 양방향 간선으로 넣어주기
            tree[w[0]].add(w[1]);
            tree[w[1]].add(w[0]);
        }
        
        // 간선 1개씩 끊고 bfs로 송전탑 개수 구하기
        
        for(int[] cut : wires){
            visited = new boolean[n+1];
            int cnt = bfs(1, cut);
            int diff = Math.abs(cnt - (n-cnt));   // 두 전력망의 송전탑 개수 차이(절대값)
            min = Math.min(diff, min);
        }
        
        return min;
    }
    
    // 송전탑 개수 리턴하기
    public static int bfs(int start, int[] cut){
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(start);
        visited[start] = true;
        int cnt = 1;    // 송전탑 개수
        
        while(!q.isEmpty()){
            int cur = q.poll();
            
            for(int next : tree[cur]){
                if(visited[next]) continue; // 이미 방문한 경우
                if(cur == cut[0] && next == cut[1]) continue;   // 끊은 간선인 경우
                if(cur == cut[1] && next == cut[0]) continue;   // 끊은 간선인 경우
                
                q.offer(next);
                visited[next] = true;
                cnt++;
                
            }
        }
        
        return cnt;
        
    }
}