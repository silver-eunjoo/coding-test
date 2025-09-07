import java.io.*;
import java.util.*;

public class Main{
    static boolean[][] visited;
    static int N;
    static int[][] arr;
    static Set<Integer> heights = new HashSet<>();
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static void dfs(int height, int i, int j){
        visited[i][j] = true;
        for(int dir=0;dir<4;dir++){
            int ny = i + dy[dir];
            int nx = j + dx[dir];
            
            if(ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
            if(arr[ny][nx] <= height || visited[ny][nx]) continue;
            dfs(height, ny, nx);
        }
        return;
    }
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        int areas = 1;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<N;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                heights.add(arr[i][j]);
            }
        }
        for(Integer height : heights) {
            int count = 0;
            visited = new boolean[N][N];
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(arr[i][j] > height && !visited[i][j]){
                        dfs(height, i, j);
                        count++;
                    }
                }
            }
            areas = Math.max(count, areas);
        }
        bw.write(String.valueOf(areas));
        bw.flush();
	}
}