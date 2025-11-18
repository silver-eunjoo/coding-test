import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int M;
    static int H;
    static char[][][] tomatoes;
    static int unriped = 0;
    static List<int[]> riped = new ArrayList<>();
    static List<int[]> added = new ArrayList<>();
    static boolean[][][] visited;
    static int day = 0;
    static int[] dx = {0, 0, 0, 0, 1, -1};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {1, -1, 0, 0, 0, 0};
    private static boolean bfs() {
        Queue<int[]> q = new ArrayDeque<>(riped);
        while(!q.isEmpty()) {
            int size = q.size();
            for(int k=0;k<size;k++){
                int[] cur = q.poll();
                for(int i=0;i<6;i++){
                    int nx = cur[1] + dx[i];
                    int ny = cur[2] + dy[i];
                    int nz = cur[0] + dz[i];
                    if(nx<0||ny<0||nz<0||nx>=N||ny>=M||nz>=H) continue;
                    if(visited[nz][nx][ny] || tomatoes[nz][nx][ny] != '0') continue;
                    tomatoes[nz][nx][ny] = '1';
                    unriped--;
                    q.offer(new int[]{nz, nx, ny});
                    visited[nz][nx][ny] = true;
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
		H = Integer.parseInt(st.nextToken());
		tomatoes = new char[H][N][M];
		visited = new boolean[H][N][M];
		for(int z=0;z<H;z++){
		    for(int x=0;x<N;x++){
		        st = new StringTokenizer(br.readLine());
		        for(int y=0;y<M;y++){
		            tomatoes[z][x][y] = st.nextToken().charAt(0);
		            if(tomatoes[z][x][y] == '1') {
		                riped.add(new int[]{z, x, y});
		                visited[z][x][y] = true;
		            }
		            if(tomatoes[z][x][y] == '0') unriped++;
		        }
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