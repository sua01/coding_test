import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        HashMap<Integer, Integer> left = new HashMap<>();
        HashMap<Integer, Integer> right = new HashMap<>();
        
        // 처음엔 왼쪽에 토핑 다 담아두기
        for(int t : topping){
            left.put(t, left.getOrDefault(t, 0)+1);
        }
        
        // 오른쪽에 토핑 하나씩 옮기면서 개수 비교하기
        for(int i=topping.length-1; i>1; i--){
            int tp = topping[i];
            
            // 오른쪽에 추가
            right.put(tp, right.getOrDefault(tp, 0)+1);
            
            // 왼쪽에서 삭제
            left.put(tp, left.get(tp)-1);
            if(left.get(tp) == 0) left.remove(tp);
            
            // 토핑 개수 비교 > 같으면 경우의 수 ++
            if(right.size() == left.size()) answer++;
        }
        
        return answer;
    }
}