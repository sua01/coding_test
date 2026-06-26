import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> c = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            c.put(clothes[i][1], c.getOrDefault(clothes[i][1], 0) + 1);
        }

        int answer = 1;

        for (int count : c.values()) {
            answer *= (count + 1);
        }

        return answer - 1;
    }
}