import java.util.*;

class Solution {
    // 최솟값, 최댓값 반환하기
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    
    public String solution(String s) {
        String answer = "";
        String[] string = s.split(" "); // 공백으로 분리하기
        
        for(int i=0; i<string.length; i++){
            int num = Integer.parseInt(string[i]);
            if(max < num){
                // 최댓값인 경우
                max = num;
            }
            if(min > num){
                // 최솟값인 경우
                min = num;
            }
        }
        
        answer = Integer.toString(min) + " " + Integer.toString(max);
        return answer;
    }
}