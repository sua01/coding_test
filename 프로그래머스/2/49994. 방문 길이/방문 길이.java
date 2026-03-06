import java.util.*;

class Solution {
    // 캐릭터가 처음 걸어본 길의 길이 구하기
    public int solution(String dirs) {
        
        // 시작 좌표, 도착 좌표 저장하기 > 중복안되니까 Set으로 저장
        HashSet<String> visited = new HashSet<>();
        
        // 경계값 넘는 명령어는 무시
        int x = 0, y=0; // 시작 좌표
        for(int i=0; i<dirs.length(); i++){
            char c = dirs.charAt(i);    // 명령어
            // 이동 후 좌표
            int nx = x;
            int ny = y;
            if(c == 'U'){
                // 위로 이동
                ny++;   
            }
            else if(c == 'D'){
                // 아래로 이동
                ny--;
            }
            else if(c == 'L'){
                // 왼쪽 이동
                nx--;
            }
            else if(c=='R'){
                // 오른쪽 이동
                nx++;
            }
            
            // 범위 체크
            if(nx < -5 || nx>5 || ny<-5 || ny >5) continue;
            
            // 범위 안 넘는 경우 길 양방향으로 저장
            String path1 = x + "," + y + "," + nx + "," + ny;
            String path2 = nx + "," + ny + "," + x + "," + y;
            
            visited.add(path1);
            visited.add(path2);
            
            // 현재 위치 이동
            x = nx;
            y = ny;
        }
        return visited.size()/2;
    }
    
}