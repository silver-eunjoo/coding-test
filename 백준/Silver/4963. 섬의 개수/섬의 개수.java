import java.io.*;
import java.util.*;

public class Main{
    static boolean[][] visited;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[][] map;
    static int h;
    static int w;
    static void dfs(int i, int j) {
        visited[i][j] = true;
        
        for(int dir=0;dir<8;dir++){
            int ny = i + dy[dir];
            int nx = j + dx[dir];
            
            if(ny >= 0 && ny < h && nx>=0 && nx<w) {
                if(map[ny][nx] == 1 && !visited[ny][nx]) {
                    dfs(ny, nx);
                }
            }
        }
    }
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int count = 0;
        while(true) {
            count = 0;
            st = new StringTokenizer(br.readLine(), " ");
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if(w==0) break;
            map = new int[h][w];
            visited = new boolean[h][w];
            for(int i=0;i<h;i++){
                st = new StringTokenizer(br.readLine(), " ");
                for(int j=0;j<w;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for(int i=0;i<h;i++){
                for(int j=0;j<w;j++){
                    if(map[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j);
                        count++;
                    }
                }
            }
            bw.write(String.valueOf(count) + "\n");
        }
        bw.flush();
	}
}