class Solution {
    public int solution(int n) {
        int answer = 0;
        
        // 2진수로 변환
        String bnum = Integer.toBinaryString(n);
        
        // 2진수의 1의 개수 카운트
        int o = countOne(bnum);
        
        // n보다 큰 수 중에서 n의 2진수 1개수가 같은 거 구하기
        int num = n;
        while(true){
            num++;
            
            // 이진수 변환
            String big = Integer.toBinaryString(num);
            
            if(o == countOne(big)){
                answer = num;
                break;
            }
        }
        
        return answer;
    }
    
    public int countOne(String bnum){
        int one = 0;
        for(int i=0; i<bnum.length(); i++){
            char c = bnum.charAt(i);
            
            if(c == '1') one++;
        }
        
        return one;
    }
}