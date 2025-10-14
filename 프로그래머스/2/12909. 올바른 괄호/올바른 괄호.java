import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        // 스택 사용하기
        ArrayDeque<Character> stack = new ArrayDeque<>();
        
        for(int i=0; i<s.length(); i++){
            // ( 면 스택 push
            if(s.charAt(i) == '(')
                stack.push('(');
            
            // ) 면 스택 pop한게 ( 인지 확인
            if(s.charAt(i) == ')'){
                if(stack.isEmpty()){
                    answer = false;
                    break;
                }
                else if(stack.peek() == '(')
                    stack.pop();
            }
        }
        
        // 스택이 안비어져있으면 false;
        if(!stack.isEmpty()){
            answer = false;
        }
        return answer;
    }
}