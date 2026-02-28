import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        // 원하는 제품, 개수 저장
        Map<String, Integer> need = new HashMap<>();
        for(int i=0; i<want.length; i++){
            need.put(want[i], number[i]);
        }
        
        // 할인 기간이 10일 미만인 경우 > X
        if(discount.length < 10){
            return 0;
        }
        
        // 슬라이딩 윈도우
        Map<String, Integer> window = new HashMap<>();
        for(int i=0; i<10; i++){
            window.put(discount[i], window.getOrDefault(discount[i], 0)+1);
        }
        
        // 첫번째 10일 구간 체크하기
        if(isValid(need, window)){
            answer++;
        }
        
        // 10일씩 체크하기 : 하나 빼고 하나 추가하기
        for(int i=10; i<discount.length; i++){
            String out = discount[i-10];
            String in = discount[i];
            
            // out 제거
            int outCnt = window.getOrDefault(out, 0) - 1;
            if(outCnt <= 0) window.remove(out);
            else window.put(out, outCnt);
            
            // in 추가
            window.put(in, window.getOrDefault(in, 0)+1);
            
            if(isValid(need, window)) answer++;
        }
        return answer;
    }
    
    // 원하는 제품이랑 10일 연속 할인 제품이 일치하는지 확인
    public boolean isValid(Map<String, Integer> need, Map<String, Integer> window){
        for(Map.Entry<String, Integer> e: need.entrySet()){
            String item = e.getKey();
            int cnt = e.getValue();
            
            if(window.getOrDefault(item, 0) != cnt) return false;
        }
        return true;
    }
}