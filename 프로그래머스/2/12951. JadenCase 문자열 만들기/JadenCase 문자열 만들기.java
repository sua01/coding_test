class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean first = true;  // 단어인지 확인
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            
            // 공백인지 판별하기
            if(c == ' '){
                // 공백인 경우
                sb.append(c);
                first = true;
            }
            else{
                // 공백 아닌 경우
                if(first){
                    // 첫 단어인 경우 > 첫 번째만 대문자
                    sb.append(Character.toUpperCase(c));
                    first = false;
                }
                else{
                    // 나머지 소문자
                    sb.append(Character.toLowerCase(c));
                }
            }   
            
        }   //for문 끝
        return sb.toString();
    }
}