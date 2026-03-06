class Solution {
    // 정확히 순위 매길 수 있는 선수의 수 반환
    public int solution(int n, int[][] results) {
        int answer = 0;
   
        // 노드 1번부터 시작
        boolean[][] win = new boolean[n+1][n+1];
        for(int[] r : results){
            win[r[0]][r[1]] = true;
        }
        
        // 플로이드워셜
        for(int k=1; k<=n; k++){
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    if(win[i][k] && win[k][j]){
                        win[i][j] = true;
                    }
                }
            }
        }
        
        for(int i=1; i<=n; i++){
            int cnt =0;
            for(int j=1; j<=n; j++){
                if(i==j) continue;
                if(win[i][j] || win[j][i]){
                    // 관계를 아는 경우
                    cnt++;
                }
            }
            
            if(cnt == n-1) answer++;    // 순위를 아는 경우
        }
        
        return answer;
    }
}