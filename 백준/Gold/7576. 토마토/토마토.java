import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int M;
    static char[][] tomatoes;
    static int unriped = 0;
    static List<int[]> riped = new ArrayList<>();
    static boolean[][] visited;
    static int day = 0;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {-1, 1, 0, 0};
    private static boolean bfs() {
        Queue<int[]> q = new ArrayDeque<>(riped);
        while(!q.isEmpty()) {
            int size = q.size();
            for(int k=0;k<size;k++){
                int[] cur = q.poll();
                for(int i=0;i<4;i++){
                    int nx = cur[0] + dx[i];
                    int ny = cur[1] + dy[i];
                    if(nx<0||ny<0||nx>=N||ny>=M) continue;
                    if(visited[nx][ny] || tomatoes[nx][ny] != '0') continue;
                    tomatoes[nx][ny] = '1';
                    unriped--;
                    q.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
            day++;
        }
        if(unriped>0) return false;
        return true;
    }
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		tomatoes = new char[N][M];
		visited = new boolean[N][M];
	    for(int x=0;x<N;x++){
	        st = new StringTokenizer(br.readLine());
	        for(int y=0;y<M;y++){
	            tomatoes[x][y] = st.nextToken().charAt(0);
	            if(tomatoes[x][y] == '1') {
	                riped.add(new int[]{x, y});
	                visited[x][y] = true;
	            }
	            if(tomatoes[x][y] == '0') unriped++;
	        }
	    }
		if(unriped==0) sb.append("0");
		else {
		    sb.append(bfs()?(day-1):"-1");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}