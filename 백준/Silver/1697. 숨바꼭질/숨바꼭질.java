import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int K;
    static int[] dx = {1, -1, 0};
    static final int MAX = 100000;
    static boolean[] visited = new boolean[MAX+1];
    private static int bfs() {
        if(N==K) return 0;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{N, 0});
        visited[N] = true;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int i=0;i<3;i++){
                if(i==2) cur[0] = cur[0]*2;
                int next = cur[0] + dx[i];
                if(next < 0 || next > MAX || visited[next]) continue;
                if(next == K) {
                    return cur[1]+1;
                }
                visited[next] = true;
                q.offer(new int[]{next, cur[1]+1});
            }
        }
        return -1;
    }
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
		bw.write(String.valueOf(bfs()));
		bw.flush();
	}
}