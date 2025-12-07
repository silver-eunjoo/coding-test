import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int M;
    static int[][] dist;
    static final int INF = 1_000_000_000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		dist = new int[N+1][N+1];
		for(int i=1;i<=N;i++){
		    Arrays.fill(dist[i], INF);
		}
		StringTokenizer st;
		while(M-->0) {
		    st = new StringTokenizer(br.readLine());
		    int a = Integer.parseInt(st.nextToken());
		    int b = Integer.parseInt(st.nextToken());
		    int cost = Integer.parseInt(st.nextToken());
		    if(dist[a][b] < cost) continue;
		    dist[a][b] = cost;
		}
		for(int k=1;k<=N;k++){
		    for(int i=1;i<=N;i++){
		        for(int j=1;j<=N;j++){
		            if(i==j) continue;
		            if(dist[i][j] > dist[i][k] + dist[k][j]) {
		                dist[i][j] = dist[i][k] + dist[k][j];
		            }
		        }
		    }
		}
		for(int i=1;i<=N;i++){
		    for(int j=1;j<=N;j++){
		        sb.append(dist[i][j]==INF?"0":dist[i][j]).append(" ");
		    }
		    sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}
