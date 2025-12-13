import java.util.*;

class Solution {
    // 완주하지 못한 선수 이름 리턴
    public String solution(String[] participant, String[] completion) {
    Map<String, Integer> cnt = new HashMap<>();   
    
        //참가자 수 세기
        for(String p: participant){
            cnt.put(p, cnt.getOrDefault(p, 0) + 1);
        }
        
        // 완주자 수 빼주기
        for(String c: completion){
            cnt.put(c, cnt.get(c) - 1);
            // 0이면 완주한거임
            if(cnt.get(c) == 0){
                cnt.remove(c);
            }
        }
         
        return cnt.keySet().iterator().next();
    }
}