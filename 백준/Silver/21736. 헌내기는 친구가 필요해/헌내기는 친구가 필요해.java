import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int M;
    static int count = 0;
    static char[][] school;
    static int[] doyeon = new int[2];
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    private static void bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(doyeon);
        visited[doyeon[0]][doyeon[1]] = true;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for(int i=0;i<4;i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if(nx<0||ny<0||nx>=N||ny>=M) continue;
                if(visited[nx][ny] || school[nx][ny]=='X') continue;
                if(school[nx][ny]=='P') count++;
                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny});
            }
        }
    }
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String input;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		school = new char[N][M];
		visited = new boolean[N][M];
		for(int i=0;i<N;i++){
		    input = br.readLine();
		    for(int j=0;j<M;j++){
		        school[i][j] = input.charAt(j);
		        if(school[i][j]=='I') {
		            doyeon[0] = i;
		            doyeon[1] = j;
		        }
		    }
		}
		bfs();
		bw.write(count==0?"TT":String.valueOf(count));
		bw.flush();
	}
}