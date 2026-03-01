class Solution {
    public String solution(String s, int n) {
        StringBuilder answer = new StringBuilder();
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            
            // 공백인 경우 > 그냥 공백
            if(c == ' ') answer.append(c);
            
            // 알파벳인 경우
            // 소문자인 경우
            if(c >= 'a' && c <='z'){
                answer.append((char)((c-'a'+n)%26+'a'));
            }
            // 대문자인 경우
            if(c >= 'A' && c <= 'Z'){
                answer.append((char)((c-'A'+n)%26+'A'));
            }
            
        }
        
        return answer.toString();
    }
}