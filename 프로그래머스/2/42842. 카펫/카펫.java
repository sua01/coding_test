class Solution {
    public int[] solution(int brown, int yellow) {
        
        int total = brown + yellow;
        
        // w*h = total > w = total/h
        for(int h=1; h*h<=total; h++){
            if(total%h != 0){
                // 약수 아닌 경우
                continue;
            }
            
            int w = total / h;
            if(w < h) continue; // 가로 >= 세로 여야함
            
            // 문제 조건 확인
            if((w-2)*(h-2) == yellow){
                return new int[]{w,h};
            }
        }
        
        return new int[]{0,0};
    }
}