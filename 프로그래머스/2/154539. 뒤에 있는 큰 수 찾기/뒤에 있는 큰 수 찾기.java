import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);    // 기본값 -1
        
        Stack<Integer> s = new Stack<>();
        for(int i=0; i<numbers.length; i++){
            while(!s.empty() && numbers[s.peek()] < numbers[i]){
                // 뒷 큰수가 있는 경우
                answer[s.pop()] = numbers[i];
            }
            s.push(i);
        }       
        
        return answer;
    }
}