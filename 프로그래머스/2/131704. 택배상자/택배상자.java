import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int l = order.length;
        int i = 0;  // order에서 원하는 상자 위치
        int container = 1;  // 컨테이너의 상자 번호
        
        Stack<Integer> sub = new Stack<>();
        while(i < l){
            // 메인 컨테이너에서 꺼낼 수 있는 경우
            if(container == order[i]){
                container++;
                answer++;
                i++;
            }
            else if(!sub.isEmpty() && sub.peek() == order[i]){
                // 보조 컨테이너 top이 트럭 상자인 경우
                answer++;
                i++;
                sub.pop();
            }
            else if(container <= l){
                // 메인 컨테이너에 남아있는 경우
                // 컨테이너에서 보조 컨테이너로 옮기는 경우
                sub.push(container);
                container++;
            }
            else{
                // 다 꺼낼 수 없는 경우
                break;
            }
            
            
        }
        
        return answer;
    }
}