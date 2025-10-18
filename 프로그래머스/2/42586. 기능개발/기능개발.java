import java.util.*;

class Solution {
    // 몇 개의 기능이 배포되는지 리턴
    static int[] progresses, speeds;
    static int day =0, cnt = 1, work =0, finished=0;
    static ArrayList<Integer> result;
    
    public int[] solution(int[] progresses, int[] speeds) {
        
        this.progresses = progresses;
        this.speeds = speeds;
        
        result = new ArrayList<>();
        for(int i=0; i<progresses.length; i++){
            work = 100 - progresses[i];
            int j = work / speeds[i];
            if(work % speeds[i] != 0){
                finished = j + 1;
            }
            else finished = j;
            
            if(day >= finished){
                cnt++;
                //result.add(cnt);
                //cnt = 0;
                //day = 0;
            }
            else{
                if(day!= 0) result.add(cnt);
                cnt=1;
                day = finished;
            }
        }
        
        result.add(cnt);
        // 앞 기능의 날짜 day=0; 7 0
        // 100 - progresses[] > work 7  70 45
        // work / speeds[], work%speeds[] 나머지가 0이 아니면 +1해주기 > finished = 7 3 9
        // 앞에꺼 day가 더 큰 경우 ++, day=0 / day가 더 작은 경우 day = finished, array에 cnt 넣고 다시 0
        int[] answer = new int[result.size()];
        for(int i=0; i<result.size(); i++){
            answer[i] = result.get(i);
        }
        
        
        return answer;
    }
}