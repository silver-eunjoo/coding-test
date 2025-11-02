import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int M;
    static int[][] farm;
    static boolean[][] visited;
    static List<int[]> lettuce;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int count = 0;
    private static void bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        for(int[] l : lettuce) {
            if(visited[l[0]][l[1]]) continue;
            count++;
            q.offer(new int[]{l[0], l[1]});
            visited[l[0]][l[1]] = true;
            while(!q.isEmpty()) {
                int[] cur = q.poll();
                for(int i=0;i<4;i++){
                    int nx = cur[0] + dx[i];
                    int ny = cur[1] + dy[i];
                    if(nx<0||ny<0||nx>=N||ny>=M) continue;
                    if(visited[nx][ny] || farm[nx][ny] == 0) continue;
                    q.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		while(T-->0) {
		    st = new StringTokenizer(br.readLine());
		    M = Integer.parseInt(st.nextToken());
		    N = Integer.parseInt(st.nextToken());
		    farm = new int[N][M];
		    visited = new boolean[N][M];
		    int K = Integer.parseInt(st.nextToken());
		    lettuce = new ArrayList<>();
		    count = 0;
		    while(K-->0) {
		        st = new StringTokenizer(br.readLine());
		        int X = Integer.parseInt(st.nextToken());
		        int Y = Integer.parseInt(st.nextToken());
		        farm[Y][X] = 1;
		        lettuce.add(new int[]{Y, X});
		    }
		    bfs();
		    sb.append(count).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}