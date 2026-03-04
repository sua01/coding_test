import java.util.*;

class Solution {
    // 가장 짧게 압축한 문자열 길이 반환
    public int solution(String s) {
        int answer = s.length();    // 압축 못했을 경우 원래 길이
        
        
       
        
        for(int i=1; i<=s.length()/2; i++){
            // 자를 문자열 단위 개수 i
            String prev = s.substring(0, i);   // 반복되는 문자열
            int cnt = 1;    // 문자열 반복되는 횟수
             StringBuilder result = new StringBuilder();    // 압축 문자열
            
            for(int j=i; j< s.length(); j+=i){
                // 반복되는 문자열 있는지 확인
                String next = s.substring(j, Math.min(j+i, s.length()));
                if(prev.equals(next)){
                    cnt++;
                }
                else{
                    // 압축 문자열에 추가
                    if(cnt != 1) result.append(cnt);
                    result.append(prev);
                    prev = next;
                    cnt = 1;
                }
            }
            // 마지막 남은 문자열까지 붙여주기
            if(cnt != 1) result.append(cnt);
            result.append(prev);

            answer = Math.min(answer, result.length());
        }
        
        
        
        return answer;
    }
}