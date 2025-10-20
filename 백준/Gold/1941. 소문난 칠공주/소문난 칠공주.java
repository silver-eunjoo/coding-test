import java.io.*;
import java.util.*;

public class Main {
    static int N = 5;
    static int R = 7;
    static char[][] arr = new char[N][N];
    static int[] selected = new int[R];
    static int answer = 0;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int yCount = 0;
    public static void combination(int start, int depth, int yCount) {
        if(yCount > 3) return;
        if(depth==R) {
            if(checkConnection()) answer++;
            return;
        }
        for(int i=start;i<N*N;i++){
            char c = arr[i/5][i%5];
            selected[depth] = i;
            combination(i+1, depth+1, c=='Y'?yCount+1:yCount);
        }
    }
    public static boolean checkConnection() {
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[R];
        q.offer(0);
        visited[0] = true;
        int cnt = 1;
        while(!q.isEmpty()) {
            int idx = q.poll();
            int r = selected[idx]/5;
            int c = selected[idx]%5;
            for(int i=0;i<4;i++){
                int nx = r+dx[i];
                int ny = c+dy[i];
                if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                int next = nx*N+ny;
                for(int j=0;j<R;j++){
                    if(visited[j] || selected[j]!=next) continue;
                    visited[j] = true;
                    cnt++;
                    q.offer(j);
                }
            }
        }
        return cnt==R;
    }
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		for(int i=0;i<N;i++){
		    String input = br.readLine();
		    for(int j=0;j<N;j++){
		        arr[i][j] = input.charAt(j);
		    }
		}
		combination(0, 0, 0);
		bw.write(String.valueOf(answer));
		bw.flush();
	}
}