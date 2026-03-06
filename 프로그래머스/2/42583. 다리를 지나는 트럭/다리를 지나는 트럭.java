import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        ArrayDeque<Integer> bridge = new ArrayDeque<>();
        
        int time = 0;   // 시간
        int idx = 0;    // 트럭 인덱스
        int sum = 0;    // 다리 위 트럭 무게 총합
        while(idx < truck_weights.length){
            time++;
            
            if(bridge.size() == bridge_length){
                // 다리 길이만큼 찼으면 맨 앞 제거
                sum-=bridge.poll();
            }
            
            // 다리에 트럭 더 올라갈 수 있는 경우
            if(sum + truck_weights[idx] <= weight){
                bridge.offer(truck_weights[idx]);
                sum+=truck_weights[idx];
                idx++;
            }
            else{
                // 무게 초과인 경우 그냥 빈칸 넣기
                bridge.offer(0);
            }
        }
        
        return time+bridge_length;
    }
}