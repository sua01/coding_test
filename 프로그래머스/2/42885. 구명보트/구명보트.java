import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        // 정렬
        Arrays.sort(people);
        
        // 투포인터 이용
        int left = 0;
        int right = people.length - 1;
        
        // 무거운 사람부터 태우기
        while(left <= right){
            if(limit - people[right] >= people[left]){
                // 더 태울 수 있는 경우
                left++;
            }
            // 무거운 사람만 탈 수 있는 경우
            right--;
            answer++;
        }
        return answer;
    }
}