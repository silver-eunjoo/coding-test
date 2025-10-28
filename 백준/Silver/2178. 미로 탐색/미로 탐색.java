import java.util.*;
import java.io.*;

public class Main {
    static char[][] arr;
    static boolean[][] visited;
    static int N;
    static int M;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int min = Integer.MAX_VALUE;
    public static void bfs() {
        Queue<int[]> q = new ArrayDeque<>(); // x, y, dist
        q.offer(new int[]{0, 0, 1});
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for(int i=0;i<4;i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(visited[nx][ny] || arr[nx][ny]=='0') continue;
                if(nx==N-1 && ny==M-1) {
                    min = Math.min(min, cur[2] + 1);
                }
                q.offer(new int[]{nx, ny, cur[2]+1});
                visited[nx][ny] = true;
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
		String input;
		arr = new char[N][M];
		visited = new boolean[N][M];
		for(int i=0;i<N;i++){
		    input = br.readLine();
		    for(int j=0;j<M;j++){
                arr[i][j] = input.charAt(j);
		    }
		}
		bfs();
		bw.write(String.valueOf(min));
		bw.flush();
	}
}