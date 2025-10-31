import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int K;
    static int[] dx = {1, -1, 0};
    static int[] move = new int[100001];
    static int min = 0;
    private static void bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{N, 0});
        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int i=0;i<3;i++){
                if(i==2) cur[0] = cur[0]*2;
                int next = cur[0] + dx[i];
                if(next < 0) continue;
                if(next > 100000) continue;
                if(next == K) {
                    min = Math.min(min, cur[1]+1);
                    continue;
                }
                if(move[next] >= cur[1]+1) move[next] = cur[1]+1;
                else continue;
                if(cur[1]+1 > min) break;
                q.offer(new int[]{next, cur[1]+1});
            }
        }
    }
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        min = Math.abs(N-K);
        Arrays.fill(move, Integer.MAX_VALUE);
		bfs();
		bw.write(String.valueOf(min));
		bw.flush();
	}
}