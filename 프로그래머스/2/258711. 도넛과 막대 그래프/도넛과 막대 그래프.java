import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int N = 0;
        int cnt = 0;
        
        for(int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            graph.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
            N = Math.max(Math.max(N, from), to);
        }
        
        int[][] degree = new int[N+1][2]; // 진입, 진출
        for(int i=1;i<=N;i++){
            if(graph.get(i)==null) continue;
            degree[i][1] = graph.get(i).size();
            for(int in : graph.get(i)) {
                degree[in][0]++;
            }
        }
        for(int i=1;i<=N;i++){
            if(degree[i][0]==0 && degree[i][1] > 1) {
                answer[0] = i;
                degree[i][0] = -1;
                degree[i][1] = -1;
                break;
            }
        }
        
        for(int i=1;i<=N;i++){
            if(answer[0] == i) continue;
            if(degree[i][1] == 2) answer[3]++;
            if(degree[i][1] == 0 && degree[i][0]>0) answer[2]++;
        }
        
        answer[1] = graph.get(answer[0]).size() - answer[2] - answer[3];
        
        return answer;
    }
}