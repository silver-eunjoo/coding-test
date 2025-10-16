import java.io.*;
import java.util.*;

public class Main {
    static int N = 5;
    static int R = 7;
    static String[][] arr = new String[N][N];
    static boolean[] visited = new boolean[N*N];
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
            int r = i/5;
            int c = i%5;
            visited[i] = true;
            combination(i+1, depth+1, arr[r][c].equals("Y")?yCount+1:yCount);
            visited[i] = false;
        }
    }
    public static boolean checkConnection() {
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] checked = new boolean[N*N];
        for(int i=0;i<N*N;i++){
            if(!visited[i]) continue;
            q.offer(i);
            checked[i] = true;
            break;
        }
        int cnt = 0;
        while(!q.isEmpty()) {
            cnt++;
            int idx = q.poll();
            int r = idx/5;
            int c = idx%5;
            
            for(int i=0;i<4;i++){
                int nx = r+dx[i];
                int ny = c+dy[i];
                if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if(!visited[nx*N+ny] || checked[nx*N+ny]) continue;
                q.offer(nx*N+ny);
                checked[nx*N+ny] = true;
            }
        }
        if(cnt==R) return true;
        return false;
    }
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		for(int i=0;i<5;i++){
		    arr[i] = br.readLine().split("");
		}
		combination(0, 0, 0);
		bw.write(String.valueOf(answer));
		bw.flush();
	}
}