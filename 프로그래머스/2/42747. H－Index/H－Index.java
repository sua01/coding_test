import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int hIndex = 0;
        
        Arrays.sort(citations); // 인용 횟수 오름차순 정렬
        int n = citations.length;   // 전체 논문 개수
        
        for(int i=0; i<n; i++){
            int h = Math.min(citations[i], n-i);
            hIndex = Math.max(hIndex, h);
        }
        
        return hIndex;
    }
}