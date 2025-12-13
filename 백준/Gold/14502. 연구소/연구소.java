import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int M;
    static int[][] lab;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int maxSafeAreaSize = 0;
    static int safeArea = 0;
    static List<int[]> virusList = new ArrayList<>();
    private static void bfs() {
        Queue<int[]> q = new ArrayDeque<>(virusList);
        int[][] copyLab = new int[N][M];
        for(int i=0;i<N;i++){
            copyLab[i] = lab[i].clone();
        }
        int cnt = safeArea-3;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for(int i=0;i<4;i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if(nx<0||ny<0||nx>=N||ny>=M) continue;
                if(copyLab[nx][ny]!=0) continue;
                copyLab[nx][ny] = 2;
                q.offer(new int[]{nx, ny});
                cnt--;
            }
        }
        maxSafeAreaSize = Math.max(maxSafeAreaSize, cnt);
    }
    private static void dfs(int start, int depth) {
        if(depth == 3) {
            bfs();
            return;
        }
        for(int i=start; i<N*M;i++){
            int x = i/M;
            int y = i%M;
            if(lab[x][y]!=0) continue;
            lab[x][y] = 1;
            dfs(i+1, depth+1);
            lab[x][y] = 0;
        }
    }
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		lab = new int[N][M];
		for(int i=0;i<N;i++){
		    st = new StringTokenizer(br.readLine());
		    for(int j=0;j<M;j++){
		        lab[i][j] = Integer.parseInt(st.nextToken());
		        if(lab[i][j] == 2) virusList.add(new int[]{i, j});
		        if(lab[i][j] == 0) safeArea++;
		    }
		}
		dfs(0, 0);
		bw.write(String.valueOf(maxSafeAreaSize));
		bw.flush();
	}
}
