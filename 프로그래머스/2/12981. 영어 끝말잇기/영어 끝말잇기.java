import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Map<Integer, Integer> turn = new HashMap<>();
        ArrayList<String> wlist = new ArrayList<>();
        
        wlist.add(words[0]);
        // 가장 먼저 탈락하는 사람의 번호, 그 사람이 자신의 몇 번째 차례에 탈락하는지
        for(int i=1; i<words.length; i++){
            String w = words[i];
            
            // 중복되는 단어인지 확인
            if(wlist.contains(w)){
                // 탈락
                return new int[]{(i%n)+1, (i/n)+1};
            }
            
            // 끝말잇기 된건지 확인
            String p = wlist.get(i-1);
            if(p.charAt(p.length()-1) != w.charAt(0)){
                return new int[]{(i%n)+1, (i/n)+1};
            }
               
            wlist.add(w);
        }

        // 탈락자 없으면 [0,0] 리턴
        return new int[]{0,0};
    }
}