import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0; // 섞은 횟수
        
        // 우선순위 큐에 기존 스코빌 지수 모두 넣기
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int s : scoville){
            pq.offer(s);
        }
        
        while(true && pq.size() >= 2){
            if(pq.peek() >= K) break;
            int one = pq.poll();
            int two = pq.poll();
            int new_s = one + two*2;
            pq.offer(new_s);
            answer++;
        }
        
        // 원소가 1개인 경우
        if(pq.poll() < K){
            return -1;
        }
        
        return answer;
    }
}