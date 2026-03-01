import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        // 큐에 우선순위 넣기
        for(int p : priorities){
            pq.offer(p);
        }
        
        // 해당 위치 확인하기
        while(!pq.isEmpty()){
            for(int i=0; i<priorities.length; i++){
                if(priorities[i] == pq.peek()){
                    pq.poll();
                    answer++;
                    
                    if(i == location){
                        return answer;
                    }
                }
            }
        }
        return answer;
    }
}