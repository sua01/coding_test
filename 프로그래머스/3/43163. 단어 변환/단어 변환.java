import java.util.*;

class Solution {
    static ArrayList<Integer>[] adjList;
    static int n, targetIdx;
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        // words에 target있는지부터 확인
        for(String s: words){
            if(s.equals(target)){
                answer = 1;
                break;
            }
        }
        if(answer != 1) return 0;   // words에 target이 없는 경우
        
        // 1글자만 다른 단어들 연결하기 - 노드 간선연결하기
        // 노드 만들기
        n = words.length + 1;   // [begin] + words
        String[] nodes = new String[n];
        
        nodes[0] = begin;
        for(int i=1; i<n; i++){
            nodes[i] = words[i-1];
            if(nodes[i].equals(target)) targetIdx = i;  // 타겟 단어 인덱스 찾아두기
        }
        
        // 간선 연결하기
        adjList = new ArrayList[n];
        for(int i=0; i<n; i++) adjList[i] = new ArrayList<>();
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                // 1글자만 다른지 판단하기
                if(checkalpha(nodes[i], nodes[j])){
                    // 간선 연결 : 무방향
                    adjList[i].add(j);
                    adjList[j].add(i);
                }
            }
        }
        
        // target 최단거리 구하기 : bfs
        bfs();
        answer = dist[targetIdx] -1;
        
        return answer;
    }
    
    // 1글자만 다른지 확인하는 함수
    public static boolean checkalpha(String a, String b){
        if(a.length() != b.length()) return false;  // 단어 길이부터 다른 경우
        int diff=0; // 다른 글자 개수 카운트하기
        for(int i=0; i<a.length();i++){
            if(a.charAt(i) != b.charAt(i)) diff++;
        }
        
        if(diff == 1){
            // 1글자만 다른 경우
            return true;
        }
        
        return false;
        
    }
    
    // target 최단거리 구하기
    static int[] dist;
    public static void bfs(){
        dist = new int[n];
        ArrayDeque<Integer> q = new ArrayDeque<>();
        dist[0] = 1;
        q.offer(0);
        
        while(!q.isEmpty()){
            int cur = q.poll();
            if(cur == targetIdx) return;
            
            for(int n:adjList[cur]){
                if(dist[n] != 0) continue;    // 이미 방문한 경우
                
                dist[n] = dist[cur] + 1;
                q.offer(n);
            }
        }
    }
}