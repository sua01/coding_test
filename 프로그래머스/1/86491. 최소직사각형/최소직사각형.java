class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int maxW = 0;  // 가로 길이
        int maxH = 0;  // 세로 길이
        
        for(int[] size : sizes){
            int w = size[0];
            int h = size[1];
            
            // 기준 통일하기 > 큰 값을 가로, 작은 값을 세로
            int big = Math.max(w, h);
            int small = Math.min(w, h);
            
            // 최대 길이 구하기
            maxW = Math.max(maxW, big);
            maxH = Math.max(maxH, small);
        }
        
        answer = maxW * maxH;        
        
        return answer;
    }
}