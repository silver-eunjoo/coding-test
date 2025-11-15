import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int M;
    static int K;
    static int X;
    static List<Integer>[] graph;
    static int[] dist;
    static int INF = 1_000_000_000;
    private static void dijkstra(int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1]-b[1]);
        pq.offer(new int[]{start, 0});
        dist[start] = 0;
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            if(cur[1] > dist[cur[0]]) continue;
            int now = cur[0];
            int cost = cur[1];
            for(int next : graph[now]) {
                int nextCost = cost + 1;
                if(nextCost < dist[next]) {
                    dist[next] = nextCost;
                    pq.offer(new int[]{next, nextCost});
                }
            }
        }
    }
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N+1];
		for(int i=1;i<=N;i++) {
		    graph[i] = new ArrayList<>();
		}
		dist = new int[N+1];
		Arrays.fill(dist, INF);
		while(M-->0) {
		    st = new StringTokenizer(br.readLine());
		    int n1 = Integer.parseInt(st.nextToken());
		    int n2 = Integer.parseInt(st.nextToken());
		    graph[n1].add(n2);
		}
		dijkstra(X);
		boolean existed = false;
		for(int i=1;i<=N;i++){
		    if(dist[i] != K) continue;
		    sb.append(i).append("\n");
		    existed = true;
		}
		if(!existed) sb.append("-1");
		bw.write(sb.toString());
		bw.flush();
	}
}