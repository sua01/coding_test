import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        
        Map<String, String> user = new HashMap<>(); // 아이디, 닉네임 저장
        List<String[]> messages = new ArrayList<>();  // 첫 단어, 아이디 저장
        
        // 최종 닉네임 구하기 : Enter, Change인 경우에만
        for(String r : record){
            String[] s = r.split(" ");
            String m = s[0];
            String id = s[1];
            
            // 닉네임 저장하기
            if(m.equals("Enter") || m.equals("Change")){
                user.put(id, s[2]);
            }
            // 메시지 저장하기
            if(!m.equals("Change")){
                messages.add(new String[]{m, id});
            }
        }
        
        // 메시지 출력하기
        String[] answer = new String[messages.size()];
        int i =0;
        for(String[] message : messages){
            String c = message[0];
            String uid = message[1];
            
            if(c.equals("Enter")){
                answer[i] = user.get(uid) + "님이 들어왔습니다.";
            }
            else if(c.equals("Leave")){
                answer[i] = user.get(uid) + "님이 나갔습니다.";
            }
            i++;
        }
        
        
        return answer;
    }
}