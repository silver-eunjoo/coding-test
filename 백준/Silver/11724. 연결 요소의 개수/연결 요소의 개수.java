import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int M;
    static List<Integer>[] graph;
    static boolean[] visited;
    static int count = 0;
    private static void dfs(int start) {
        visited[start] = true;
        for(int next : graph[start]) {
            if(visited[next]) continue;
            dfs(next);
        }
    }
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N+1];
		visited = new boolean[N+1];
		for(int i=1;i<=N;i++){
		    graph[i] = new ArrayList<>();
		}
		while(M-->0) {
		    st = new StringTokenizer(br.readLine());
		    int n1 = Integer.parseInt(st.nextToken());
		    int n2 = Integer.parseInt(st.nextToken());
		    graph[n1].add(n2);
		    graph[n2].add(n1);
		}
		for(int i=1;i<=N;i++){
		    if(visited[i]) continue;
		    count++;
		    dfs(i);
		}
		bw.write(String.valueOf(count));
		bw.flush();
	}
}