import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        
        int s1 = 0, s2=0, s3=0; // 맞힌 점수
        
        int[] st1 = {1, 2, 3, 4, 5};
        int[] st2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] st3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        // 점수 계산
        for(int i=0; i<answers.length; i++){
            if(answers[i] == st1[i%st1.length]) s1++;
            if(answers[i] == st2[i%st2.length]) s2++;
            if(answers[i] == st3[i%st3.length]) s3++;
        }
        
        
        int max = Math.max(s1, Math.max(s2, s3));
        int cnt = 0;    // answer 배열 크기 구하기
        if(max == s1) cnt++;
        if(max == s2) cnt++;
        if(max == s3) cnt++;
        answer = new int[cnt];
        cnt = 0;
        
        // 가장 높은 점수 받은 사람 구하기
        if(max == s1) answer[cnt++] = 1;
        if(max == s2) answer[cnt++] = 2;
        if(max == s3) answer[cnt++] = 3;
         
        return answer;
    }
}