import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = {};
        
        Stack<Integer> s = new Stack<>();
        int n = prices.length;
        answer = new int[n];
        s.push(0);
        
        for(int i=1; i<n; i++){
            while(!s.isEmpty() && prices[s.peek()] > prices[i]){
                // 가격 떨어진 경우
                int p = s.pop();
                answer[p] = i - p;
            }
            s.push(i);
        }
        
        while(!s.isEmpty()){
            int p = s.pop();
            answer[p] = n - 1 - p;
        }
        
        return answer;
    }
}