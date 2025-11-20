import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static char[][] color;
    static boolean colorBlindness = false;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] visited;
    private static void bfs(char target, int i, int j) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{i, j});
        visited[i][j] = true;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for(int dir=0;dir<4;dir++){
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];
                if(nx<0||ny<0||nx>=N||ny>=N) continue;
                if(visited[nx][ny]) continue;
                if(!colorBlindness && color[nx][ny] != target) continue;
                if(colorBlindness && (target=='R' || target=='G') && color[nx][ny] == 'B') continue;
                if(target=='B' && color[nx][ny]!='B') continue;
                q.offer(new int[]{nx, ny});
                visited[nx][ny] = true;
            }
        }
    }
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		color = new char[N][N];
		visited = new boolean[N][N];
		String input;
		for(int i=0;i<N;i++){
		    input = br.readLine();
		    for(int j=0;j<N;j++){
		        color[i][j] = input.charAt(j);
		    }
		}
		int T = 2;
		while(T-->0) {
		    int count = 0;
		    for(int i=0;i<N;i++){
    		    for(int j=0;j<N;j++){
    		        if(visited[i][j]) continue;
    		        bfs(color[i][j], i, j);
    		        count++;
    		    }
    		}
    		sb.append(count).append(" ");
    		visited = new boolean[N][N];
		    colorBlindness = true;
		}
		bw.write(sb.toString());
		bw.flush();
	}
}