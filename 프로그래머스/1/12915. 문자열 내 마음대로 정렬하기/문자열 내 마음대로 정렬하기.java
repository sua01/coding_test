import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        
        // 오름차순 정렬
        // 인덱스의 문자 같은 경우 > 사전순
        
        Arrays.sort(strings, (a,b)->{
            if(a.charAt(n)== b.charAt(n)){
                // 사전순
                return a.compareTo(b);
            }
            return a.charAt(n) - b.charAt(n);   // 오름차순 정렬
        });
        return strings;
    }
}