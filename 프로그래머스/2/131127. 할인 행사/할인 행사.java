import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        int n = 0;  // 총 원하는 제품 수량
        for(int num : number){
            n+= num;
        }
        
        // 원하는 물품, 개수 해시맵 저장
        HashMap<String, Integer> w = new HashMap<>();
        for(int i=0; i<want.length;i++){
            w.put(want[i], number[i]);
        }
        
        // 윈도우 슬라이딩으로 비교
        // 먼저 n개 넣어두기
        HashMap<String, Integer> s = new HashMap<>();
        for(int i=0; i<n; i++){
            s.put(discount[i], s.getOrDefault(discount[i], 0)+1);
        }
        
        for(int i=0; i<=discount.length-n; i++){
            // 비교
            if (w.equals(s)) answer++;
            
            // 슬라이딩 밀기
            if(i == discount.length - n) break; // 끝이라서 안밀어도 되야하는 경우
            s.put(discount[i], s.getOrDefault(discount[i], 0)-1);
            if(s.getOrDefault(discount[i], 0) == 0) s.remove(discount[i]);
            s.put(discount[i+n], s.getOrDefault(discount[i+n], 0)+1);
            
        }
        
        return answer;
    }
}