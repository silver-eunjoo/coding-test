import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int D;
    static List<int[]>[] shortcut;
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
            for(int[] next : shortcut[now]) {
                int nextPos = next[0];
                int nextCost = cost + next[1];
                if(nextCost < dist[nextPos]) {
                    dist[nextPos] = nextCost;
                    pq.offer(new int[]{nextPos, nextCost});
                }
            }
            if(now + 1 <= D && dist[now] + 1 < dist[now+1]) {
                dist[now+1] = dist[now] + 1;
                pq.offer(new int[]{now+1, dist[now+1]});
            }
        }
    }
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		shortcut = new ArrayList[D+1];
		for(int i=0;i<=D;i++) shortcut[i] = new ArrayList<>();
		dist = new int[D+1];
		Arrays.fill(dist, INF);
		while(N-->0) {
		    st = new StringTokenizer(br.readLine());
		    int n1 = Integer.parseInt(st.nextToken());
		    int n2 = Integer.parseInt(st.nextToken());
		    int d = Integer.parseInt(st.nextToken());
		    if(n1>D||n2>D||(n2-n1)<=d) continue;
		    shortcut[n1].add(new int[]{n2, d});
		}
		dijkstra(0);
		sb.append(dist[D]);
		bw.write(sb.toString());
		bw.flush();
	}
}