import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        Map<Integer, Integer> cnt = new HashMap<>();  // 크기별 개수 저장
        for(int t : tangerine){
            cnt.put(t, cnt.getOrDefault(t, 0)+1);
        }
        
        // 개수만 뽑아내기
        ArrayList<Integer> list = new ArrayList<>(cnt.values());
        // 개수 내림차순
        list.sort(Collections.reverseOrder());
        
        //k개 채우기
        int sum=0;
        for(int l : list){
            sum+=l;
            answer++;
            if(sum >= k){
                //k개 이상 채운 경우 종료
                break;
            }
        }
        
        return answer;
    }
}