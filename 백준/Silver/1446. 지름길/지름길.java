import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int D;
    static List<int[]>[] way;
    static int[] dist;
    static int INF = 1_000_000_000;
    private static void dijkstra(int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1]-b[1]);
        pq.offer(new int[]{start, 0});
        dist[start] = 0;
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int pos = cur[0];
            int cost = cur[1];
            if(cost>dist[pos]) continue;
            for(int[] next : way[pos]) {
                int nextPos = next[0];
                int nextCost = cost + next[1];
                if(nextCost < dist[nextPos]) {
                    dist[nextPos] = nextCost;
                    pq.offer(new int[]{nextPos, nextCost});
                }
            }
        }
    }
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		dist = new int[D+1];
		Arrays.fill(dist, INF);
		way = new ArrayList[D+1];
		for(int i=0;i<=D;i++) {
		    way[i] = new ArrayList<>();
		    if(i!=D) way[i].add(new int[]{i+1, 1});
		}
		while(N-->0) {
		    st = new StringTokenizer(br.readLine());
		    int start = Integer.parseInt(st.nextToken());
		    int end = Integer.parseInt(st.nextToken());
		    int cost = Integer.parseInt(st.nextToken());
		    if(start>D||end>D||(end-start)<=cost) continue;
		    way[start].add(new int[]{end, cost});
		}
		dijkstra(0);
		bw.write(String.valueOf(dist[D]));
		bw.flush();
	}
}