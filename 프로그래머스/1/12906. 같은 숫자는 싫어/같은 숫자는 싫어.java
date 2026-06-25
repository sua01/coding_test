import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        
        ArrayDeque<Integer> s = new ArrayDeque<>();
        int n = arr.length;
        s.addLast(0);
        for(int i=1; i<n; i++){
            if(arr[s.peekLast()] == arr[i]){
                // 연속된 경우
                continue;
            }
            // 연속 아닌 경우
            s.addLast(i);
        }
        
        int ss = s.size();
        answer = new int[ss];
        
        for(int i=0; i<ss; i++){
            int p = s.pollFirst();
            answer[i] = arr[p];
        }

        return answer;
    }
}