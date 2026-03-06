class Solution {
    // 짝수번째 알파벳은 대문자, 홀수번째 알파벳은 소문자로 바꾼 문자열 리턴
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        
        int cnt =0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == ' '){
                // 공백인 경우
                answer.append(" ");
                cnt = 0;
            }
            else if(cnt%2==0){
                // 짝수번째 알파벳인 경우
                answer.append(Character.toUpperCase(c));
                cnt++;
            }
            else{
                // 홀수번째 알파벳인 경우
                answer.append(Character.toLowerCase(c));
                cnt++;
            }
        }
        
        return answer.toString();
    }
}