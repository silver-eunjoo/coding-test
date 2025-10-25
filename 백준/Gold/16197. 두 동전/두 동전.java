import java.util.*;
import java.io.*;

public class Main {
    static boolean[][][][] visited;
    static int N;
    static int M;
    static char[][] board;
    static int[][] coin = new int[2][2];
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int min = Integer.MAX_VALUE;
    public static void bfs() {
        Queue<int[]> q = new ArrayDeque<>(); // i, j, dist
        q.offer(new int[]{coin[0][0], coin[0][1], coin[1][0], coin[1][1], 0});
        visited[coin[0][0]][coin[0][1]][coin[1][0]][coin[1][1]] = true;
        visited[coin[1][0]][coin[1][1]][coin[0][0]][coin[0][1]] = true;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            if(cur[4] >= 10) continue;
            for(int i=0;i<4;i++){
                int nx1 = cur[0] + dx[i];
                int ny1 = cur[1] + dy[i];
                int nx2 = cur[2] + dx[i];
                int ny2 = cur[3] + dy[i];
                if((nx1 < 0 || ny1 < 0 || nx1 >= N || ny1 >= M) ^ (nx2 < 0 || ny2 < 0 || nx2 >= N || ny2 >= M)) {
                    min = Math.min(min, cur[4] + 1);
                    continue;
                } else {
                    if(nx1 < 0 || ny1 < 0 || nx1 >= N || ny1 >= M || nx2 < 0 || ny2 < 0 || nx2 >= N || ny2 >= M) continue;
                }
                if(visited[nx1][ny1][nx2][ny2] || visited[nx2][ny2][nx1][ny1]) continue;
                if(board[nx1][ny1]=='#') {
                    nx1 = cur[0];
                    ny1 = cur[1];
                }
                if(board[nx2][ny2]=='#') {
                    nx2 = cur[2];
                    ny2 = cur[3];
                }
                q.offer(new int[]{nx1, ny1, nx2, ny2, cur[4] + 1});
                visited[nx1][ny1][nx2][ny2] = true;
                visited[nx2][ny2][nx1][ny1] = true;
            }
        }
    }
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new char[N][M];
		visited = new boolean[N][M][N][M];
		int idx = 0;
		for(int i=0;i<N;i++){
		    String input = br.readLine();
		    for(int j=0;j<M;j++){
		        board[i][j] = input.charAt(j);
		        if(board[i][j]=='o') {
		            coin[idx][0] = i;
		            coin[idx++][1] = j;
		        }
		    }
		}
		bfs();
		bw.write(min<=10?String.valueOf(min):"-1");
		bw.flush();
	}
}