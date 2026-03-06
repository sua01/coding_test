import java.util.*;

class Solution {
    // 서로 다른 옷의 조합의 수
    public int solution(String[][] clothes) {
        int answer = 1;
        
        // 해시맵 > 종류별로 개수 저장하기
        HashMap<String, Integer> cnt = new HashMap<>();
        for(String[] c : clothes){
            cnt.put(c[1], cnt.getOrDefault(c[1], 0)+1);
        }
        
        // 조합의 수 구하기
        for(int v : cnt.values()){
            answer*= (v+1);
        }
        
        return answer-1;    // 모두 안 입는 경우의 수 제외
    }
}