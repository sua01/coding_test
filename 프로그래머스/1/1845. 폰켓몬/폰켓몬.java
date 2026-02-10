import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        Map<Integer, Integer> pocket = new HashMap<>();
        
        // 폰켓몬 종류 별로 마리 저장
        for(int num: nums){
            pocket.put(num, pocket.getOrDefault(num, 0) + 1);
        }
        
        int n = nums.length;
        if(n/2 < pocket.size()){
            answer = n/2;
        }
        else{
            answer = pocket.size();
        }
        
        // 가장 많은 종류의 폰켓몬 선택
        return answer;
    }
}