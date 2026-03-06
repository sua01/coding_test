class Solution {
    // p, y 개수 같으면 True, 다르면 False 리턴
    boolean solution(String s) {
        boolean answer = true;

        // 대소문자 구별X
        int p = 0, y =0;
        for(int i=0; i<s.length(); i++){
            char c = Character.toLowerCase(s.charAt(i));
            
            if(c == 'p'){
                p++;
            }
            else if(c== 'y'){
                y++;
            }
        }
        
        
        return (p==y)? true: false;

    }
}