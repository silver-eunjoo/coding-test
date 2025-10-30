import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int M;
    static char[][] board;
    static boolean[][] visited;
    static List<int[]> melted = new ArrayList<>();
    static int total = 0;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    private static void bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});
        visited[0][0] = true;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for(int i=0;i<4;i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if(nx<0||ny<0||nx>=N||ny>=M) continue;
                if(visited[nx][ny]) continue;
                if(board[nx][ny]=='1') {
                    melted.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    continue;
                }
                q.offer(new int[]{nx, ny});
                visited[nx][ny] = true;
            }
        }
        for(int[] melt : melted) {
            board[melt[0]][melt[1]] = '0';
        }
        total-=melted.size();
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
		    melted.clear();
		    visited = new boolean[N][M];
		    time++;
		    bfs();
		}
		sb.append(time).append("\n");
		sb.append(melted.size());
		bw.write(sb.toString());
		bw.flush();
	}
}