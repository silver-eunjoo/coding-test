import java.util.*;
import java.io.*;

public class Main {
    static boolean[] visited;
    static int N;
    static List<Integer>[] graph;
    static StringBuilder sb = new StringBuilder();
    public static void dfs(int start) {
        visited[start] = true;
        sb.append(start + " ");
        Collections.sort(graph[start]);
        for(int i=0;i<graph[start].size();i++){
            int node = graph[start].get(i);
            if(visited[node]) continue;
            visited[node] = true;
            dfs(node);
        }
    }
    public static void bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        for(int i=0;i<graph[start].size();i++){
            q.offer(graph[start].get(i));
        }
        visited[start] = true;
        sb.append(start + " ");
        while(!q.isEmpty()) {
            int dest = q.poll();
            if(visited[dest]) continue;
            visited[dest] = true;
            sb.append(dest + " ");
            for(int i=0;i<graph[dest].size();i++){
                q.offer(graph[dest].get(i));
            }
        }
    }
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
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
		dfs(start);
		sb.append("\n");
		visited = new boolean[N+1];
		bfs(start);
		bw.write(sb.toString());
		bw.flush();
	}
}