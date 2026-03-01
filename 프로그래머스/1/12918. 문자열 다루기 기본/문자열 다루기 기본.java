class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        
        if(s.length() != 4 && s.length() != 6) return false;
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            
            int ascii = (int)c;
            if(ascii >= 65 && ascii <=90){
                return false;
            }
            if(ascii >= 97 && ascii <=122){
                return false;
            }
        }
        return answer;
    }
}