class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        StringBuilder sb = new StringBuilder(); // 0제거하고 문자열 붙이기
        
        int bnum = 0; // 이진변환 횟수 저장
        int zero = 0; // 0 제거한 횟수 저장
        
        // 1 될때까지 반복
        while(!s.equals("1")){
            bnum++;
            
            sb.setLength(0);    // sb 비우고 시작
            // 0제거하기
            for(int i=0; i<s.length(); i++){
                char c = s.charAt(i);

                if(c == '1'){
                    sb.append(c);
                }
                else{
                    // 제거한 0 개수 저장
                    zero++;
                }
            }   //for문 종료

            // 길이 구하기
            int l = sb.length();
            
            // 이진수 변환하기
            s = Integer.toBinaryString(l);
            
        }   //while문 종료
        
        answer = new int[]{bnum, zero};
        
        
        return answer;
    }
}