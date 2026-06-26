import java.util.*;

class Solution {
    public int solution(String name) {
        int answer = 0;
        
        int n = name.length();
        int move = n-1; // 커서 오른쪽으로만 쭉 가는 경우
        
        for(int i=0; i<name.length(); i++){
            char c = name.charAt(i);
            
            if(c != 'A'){
                // A 아닌 경우 > 위 아래 이동도 해야함
                int a = c - 'A';
                int z = 'Z' - c + 1;
                answer+= Math.min(a,z);
            }
            // 좌우 커서 이동
            // 좌/우 이동 최적화
            int next = i + 1;

            // i 다음부터 연속된 A 구간 찾기
            while (next < n && name.charAt(next) == 'A') {
                next++;
            }

            // 오른쪽으로 갔다가 다시 왼쪽으로 돌아가는 경우
            move = Math.min(move, i * 2 + (n - next));

            // 왼쪽으로 먼저 갔다가 오른쪽으로 돌아오는 경우
            move = Math.min(move, i + (n - next) * 2);
        }
        
        return answer + move;
    }
}