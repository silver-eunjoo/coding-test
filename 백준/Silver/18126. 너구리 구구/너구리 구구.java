import java.io.*;
import java.util.*;

public class Main{
    static List<int[]>[] routes;
    static long maxDist = 0;
    public static void dfs(int start, long dist, int prev) {
        for(int[] route : routes[start]) {
            if(route[0]!=prev){
                dfs(route[0], dist+route[1], start);
            }
        }
        if(dist > maxDist) maxDist = dist;
    }
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        routes = new ArrayList[N+1];
        for(int i=1;i<=N;i++) {
            routes[i] = new ArrayList<>();
        }
        for(int i=0;i<N-1;i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            routes[a].add(new int[]{b, c});
            routes[b].add(new int[]{a, c});
        }
        dfs(1, 0, 0);
        bw.write(String.valueOf(maxDist));
        bw.flush();
	}
}