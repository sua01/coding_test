class Solution
{
    public int solution(String s)
    {
        int answer = -1;

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            int l = sb.length();       
            
            if(l > 0 && sb.charAt(l-1) == c){
                sb.deleteCharAt(l-1);
            }
            else{
                sb.append(c);
            }
        }

        return sb.length() == 0 ? 1 : 0;
    }
}