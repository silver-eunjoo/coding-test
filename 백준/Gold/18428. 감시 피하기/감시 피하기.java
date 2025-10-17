import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static final int O = 3;
    static int T = 0;
    static String[][] aisle;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static StringBuilder sb = new StringBuilder();
    static boolean found = false;
    private static boolean bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!aisle[i][j].equals("T")) continue;
                q.offer(new int[]{i, j});
                if(q.size() == T) break;
            }
            if(q.size() == T) break;
        }
        while(!q.isEmpty()) {
            int[] t = q.poll();
            for(int i=0;i<4;i++){
                int nx = t[0];
                int ny = t[1];
                boolean obstacleFound = false;
                while(!obstacleFound) {
                    nx += dx[i];
                    ny += dy[i];
                    if(nx < 0 || ny < 0 || nx >= N || ny >= N) break;
                    if(aisle[nx][ny].equals("O")) obstacleFound = true;
                    else if(aisle[nx][ny].equals("S")) return false;
                }
            }
        }
        return true;
    }
    private static void avoidTeachers(int depth, int start) {
        if(found) return;
        if(depth == O) {
            if(bfs()) found = true;
            return;
        }
        for(int i = start;i<N*N;i++){
            int r = i/N;
            int c = i%N;
            if(!aisle[r][c].equals("X")) continue;
            aisle[r][c] = "O";
            avoidTeachers(depth + 1, i + 1);
            aisle[r][c] = "X";
        }
    }
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		aisle = new String[N][N];
		for(int i=0;i<N;i++){
		    st = new StringTokenizer(br.readLine());
		    for(int j=0;j<N;j++){
		        aisle[i][j] = st.nextToken();
		        if(aisle[i][j].equals("T")) T++;
		    }
		}
		avoidTeachers(0, 0);
		if(found) sb.append("YES");
		else sb.append("NO");
		bw.write(sb.toString());
		bw.flush();
	}
}