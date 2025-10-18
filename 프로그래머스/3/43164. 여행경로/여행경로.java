import java.util.*;

class Solution {
    static ArrayList<String> route;
    static boolean[] visited;
    static String[][] tickets;
    static boolean found = false;
    
    public String[] solution(String[][] tickets) {
        this.tickets = tickets;
        // tickets의 목적지랑 출발지가 같은 거 연결하기
        // 주어진 항공권 모두 사용하기 > DFS 백트래킹 탐색하기 > 경로 여러개면 알파벳 순서로
        
        // 목적지를 사전순으로 정렬하기
        Arrays.sort(tickets, (a,b)-> {
            if(a[0].equals(b[0])) return a[1].compareTo(b[1]);
            return a[0].compareTo(b[0]);
        });
        
        route = new ArrayList<>();
        route.add("ICN");
        visited = new boolean[tickets.length];
        dfs("ICN", 0);
        
        // 리스트를 배열로 변환
        return route.toArray(new String[0]);
    }
    
    
    public static void dfs(String start, int used){
        if(found) return;
        
        if(used == tickets.length){
            // 항공권 모두 사용했을 경우
            found = true;
            return;
        }
        
        for(int i=0; i<tickets.length; i++){
            if(!visited[i] && tickets[i][0].equals(start)){
                visited[i] = true;
                route.add(tickets[i][1]);
                dfs(tickets[i][1], used + 1);
                if (found) return; // 정답 완성되면 더 안 탐색
                route.remove(route.size() - 1);
                visited[i] = false;
            }
        }
    }
}