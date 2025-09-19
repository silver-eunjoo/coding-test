import java.io.*;
import java.util.*;

public class Main{
    static List<int[]>[] routes;
    public static long dfs(int start, long dist, int prev, int target) {
        for(int[] route : routes[start]) {
            if(route[0]!=prev){
                if(route[0]==target) return dist+route[1];
                else {
                    long answer = dfs(route[0], dist+route[1], start, target);
                    if(answer!=0) return answer;
                }
            }
        }
        return 0;
    }
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        routes = new ArrayList[N+1];
        for(int i=1;i<=N;i++) {
            routes[i] = new ArrayList<>();
        }
        for(int i=0;i<N-1;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            routes[a].add(new int[]{b, c});
            routes[b].add(new int[]{a, c});
        }
        while(M-->0) {
            st = new StringTokenizer(br.readLine(), " ");
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            if(n1==n2) sb.append("0\n");
            else {
                sb.append(dfs(n1, 0, 0, n2)+"\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
	}
}