import java.util.*;

class Solution {
    // phone_book 의 전화번호가 다른 번호의 접두어이면 false, 아니면 true
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        
        for(int i=0; i<phone_book.length - 1; i++){
            if(phone_book[i+1].startsWith(phone_book[i])){
                return false;
            }
        }
        return true;
    }
}