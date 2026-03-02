import java.util.*;

class Solution {
    public int solution(int[] elements) {
        
        int l = elements.length;    // 원소 개수
        Set<Integer> s = new HashSet<>();   // 중복 제거
        for(int i=0; i<l; i++){ // 시작점
            int sum = 0;
            for(int j=0; j<l; j++){ // 원형 인덱스로 더하기
                sum+=elements[(i+j)%l];
                s.add(sum);
            }
        }
        
        return s.size();
    }
}