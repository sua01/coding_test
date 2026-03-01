import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        // 알파벳마다 인덱스(위치) 저장하기
        Map<Character, Integer> index = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            
            // 처음 나온 문자인지 확인 > -1
            if(index.getOrDefault(c, -1) == -1){
                answer[i] = -1;
            }
            
            // 자신보다 앞에 같은 문자가 있는 경우
            else{
                answer[i] = i - index.get(c);
            }
            
            index.put(c, i);
        }
        return answer;
    }
}