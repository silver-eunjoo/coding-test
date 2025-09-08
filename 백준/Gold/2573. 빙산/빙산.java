import java.io.*;
import java.util.*;

public class Main{
    static boolean[][] visited;
    static int N;
    static int M;
    static int[][] arr;
    static int[][] zeros;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static void bfs(int i, int j){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{i, j});
        visited[i][j] = true;
        
        while(!q.isEmpty()) {
            int[] pos = q.poll();
            
            for(int dir=0;dir<4;dir++){
                int ny = pos[0] + dy[dir];
                int nx = pos[1] + dx[dir];
                
                if(ny < 0 || ny >= N || nx < 0 || nx >=M) continue;
                if(arr[ny][nx]==0 || visited[ny][nx]) continue;
                q.offer(new int[]{ny, nx});
                visited[ny][nx] = true;
            }
        }
    }
    static void countZeros(int i, int j) {
        int zeroCount = 0;
        for(int dir=0;dir<4;dir++){
            int ny = i + dy[dir];
            int nx = j + dx[dir];
            if(ny < 0 || ny >= N || nx < 0 || nx >=M) continue;
            if(arr[ny][nx]==0) zeroCount++;
        }
        zeros[i][j] = zeroCount;
    }
    static void yearsLater() {
        for(int i=0;i<N;i++){
            for(int j= 0;j<M;j++){
                if(arr[i][j] != 0) countZeros(i, j);
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                arr[i][j] = arr[i][j] < zeros[i][j] ? 0 : arr[i][j]-zeros[i][j];
            }
        }
    }
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        zeros = new int[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<M;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int year = 0;
        int temp = 0;
        while(temp<2) {
            temp = 0;
            visited = new boolean[N][M];
            year++;
            yearsLater();
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(arr[i][j]!=0 && !visited[i][j]) {
                        temp++;
                        bfs(i, j);
                    }
                }
            }
            if(temp==0){
                year = 0;
                break;
            }
        }
        bw.write(String.valueOf(year));
        bw.flush();
	}
}