import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static char[][] map;
    static boolean[][] visited;
    static List<Integer> area = new ArrayList<>();
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    private static void bfs(int x, int y) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;
        int cnt = 1;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for(int i=0;i<4;i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if(nx<0||ny<0||nx>=N||ny>=N) continue;
                if(visited[nx][ny] || map[nx][ny]=='0') continue;
                cnt++;
                q.offer(new int[]{nx, ny});
                visited[nx][ny] = true;
            }
        }
        area.add(cnt);
    }
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		visited = new boolean[N][N];
		String input;
		for(int i=0;i<N;i++){
		    input = br.readLine();
		    for(int j=0;j<N;j++){
		        map[i][j] = input.charAt(j);
		    }
		}
		for(int i=0;i<N;i++){
		    for(int j=0;j<N;j++){
		        if(visited[i][j] || map[i][j]=='0') continue;
		        bfs(i, j);
		    }
		}
		Collections.sort(area);
		sb.append(area.size() + "\n");
		for(int cnt : area) {
		    sb.append(cnt+"\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}