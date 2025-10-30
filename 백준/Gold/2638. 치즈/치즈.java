import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int M;
    static char[][] board;
    static int[][] visited;
    static int total = 0;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    private static void bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});
        visited[0][0] = 1;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for(int i=0;i<4;i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if(nx<0||ny<0||nx>=N||ny>=M) continue;
                if(board[nx][ny]=='1') {
                    visited[nx][ny]++;
                    continue;
                }
                if(visited[nx][ny]>=1) continue;
                q.offer(new int[]{nx, ny});
                visited[nx][ny] = 1;
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(visited[i][j]<2) continue;
                board[i][j] = '0';
                total--;
            }
        }
    }
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new char[N][M];
		for(int i=0;i<N;i++){
		    st = new StringTokenizer(br.readLine());
		    for(int j=0;j<M;j++){
		        board[i][j] = st.nextToken().charAt(0);
		        if(board[i][j]=='1') total++;
		    }
		}
		int time = 0;
		while(total>0) {
		    visited = new int[N][M];
		    time++;
		    bfs();
		}
		sb.append(time);
		bw.write(sb.toString());
		bw.flush();
	}
}