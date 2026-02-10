import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        ArrayList<String> s = new ArrayList<>();
        
        for(int num : numbers){
            s.add(String.valueOf(num));
        }
        
        Collections.sort(s, (a, b) -> (b+a).compareTo(a+b));
        
        // 그냥 0인 경우도 고려
        if(s.get(0).equals("0")) return "0";
        
        for(String st : s){
            answer.append(st);
        }
        
        
        return answer.toString();
    }
}