class Solution {
    public int solution(int n) {
        int answer = 0; // 방법의 수
        int start =1,end = 1;
        int sum = 1;    // 연속된 자연수들 합
        
        while(start<=n){
            if(sum == n){
                answer++;
                end++;
                if(end > n) break;
                sum+=end;
            }
            else if(sum < n){
                // 자연수 더하기
                end++;
                if(end > n) break;
                sum+=end;
            }
            else{
                // sum > n
                // 자연수 빼기
                sum-=start;
                start++;
                
            }
        }
        return answer;
    }
}