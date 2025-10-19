import java.util.*;
import java.io.*;

public class Main {
    static int N, K;
    static int S;
    static int X, Y;
    static int[][] arr;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static List<int[]> virusList = new ArrayList<>();
    public static void bfs() {
        Queue<int[]> q = new ArrayDeque<>(virusList);
        while(!q.isEmpty() && S>0 && arr[X-1][Y-1]==0) {
            int[] virus = q.poll();
            if(virus[2]==virusList.size()) S--;
            for(int i=0;i<4;i++){
                int nx = virus[0] + dx[i];
                int ny = virus[1] + dy[i];
                int type = virus[2];
                if(nx<0||ny<0||nx>=N||ny>=N) continue;
                if(arr[nx][ny]!=0) continue;
                arr[nx][ny] = type;
                q.offer(new int[]{nx, ny, type});
            }
        }
    }
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		for(int i=0;i<N;i++){
		    st = new StringTokenizer(br.readLine());
		    for(int j=0;j<N;j++){
		        arr[i][j] = Integer.parseInt(st.nextToken());
		        if(arr[i][j]==0) continue;
		        virusList.add(new int[]{i, j, arr[i][j]});
		    }
		}
		virusList.sort((Comparator.comparingInt(a->a[2])));
		st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		bfs();
		bw.write(String.valueOf(arr[X-1][Y-1]));
		bw.flush();
	}
}