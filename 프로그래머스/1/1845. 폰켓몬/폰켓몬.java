import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0; // 가장 많은 종류의 폰켓몬 선택했을 때의 종류 번호 개수
        
        HashMap<Integer, Integer> p = new HashMap<>();
        for(int n : nums){
            p.put(n, p.getOrDefault(n, 0)+1);
        }
        
        int m = nums.length/2;
        if(p.size() < m) answer = p.size();
        else answer = m;
        return answer;
    }
}