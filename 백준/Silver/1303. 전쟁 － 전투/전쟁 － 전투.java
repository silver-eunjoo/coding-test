import java.io.*;
import java.util.*;

public class Main{
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static char[][] map;
    static int N;
    static int M;
    static int dfs(int i, int j, char target) {
        int res = 1;
        visited[i][j] = true;
        
        for(int dir=0;dir<4;dir++){
            int ny = i + dy[dir];
            int nx = j + dx[dir];
            
            if(ny < 0 || ny >= M || nx < 0 || nx >=N) continue;
            if(map[ny][nx]!=target || visited[ny][nx]) continue;
            res += dfs(ny, nx, target);
        }
        return res;
    }
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); // 가로
        M = Integer.parseInt(st.nextToken()); // 세로
        map = new char[M][N];
        visited = new boolean[M][N];
        int[] power = new int[2];
        for(int i=0;i<M;i++){
            String input = br.readLine();
            for(int j=0;j<N;j++){
                map[i][j] = input.charAt(j);
            }
        }
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                if(!visited[i][j]){
                    int res = dfs(i, j, map[i][j]);
                    if(map[i][j]=='W') power[0]+=res*res;
                    else power[1]+=res*res;
                }
            }
        }
        bw.write(power[0] + " " + power[1]);
        bw.flush();
	}
}