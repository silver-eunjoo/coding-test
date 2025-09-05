import java.io.*;
import java.util.*;

public class Main{
    static boolean[] visited;
    static int[] start;
    static int[] end;
    static int[][] con;
    static int N;
    static int manhatten(int[] here, int[] there) {
        return Math.abs(here[0] - there[0]) + Math.abs(here[1] - there[1]);
    }
    static boolean dfs(int[] current) {
        if(current[0]==end[0] && current[1]==end[1]) return true;
        if(manhatten(end, current) <= 1000) {
            return dfs(end);
        }
        for(int i=0;i<N;i++){
            if(!visited[i]) {
                if(manhatten(current, con[i]) <= 1000) {
                    visited[i] = true;
                    if(dfs(con[i])) return true;
                }
            }
        }
        return false;
    }
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        while(T-->0) {
            N = Integer.parseInt(br.readLine());
            visited = new boolean[N];
            start = new int[2];
            end = new int[2];
            con = new int[N][2];
            st = new StringTokenizer(br.readLine(), " ");
            start[0] = Integer.parseInt(st.nextToken());
            start[1] = Integer.parseInt(st.nextToken());
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine(), " ");
                con[i][0] = Integer.parseInt(st.nextToken());
                con[i][1] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine(), " ");
            end[0] = Integer.parseInt(st.nextToken());
            end[1] = Integer.parseInt(st.nextToken());
            bw.write(dfs(start)?"happy\n":"sad\n");
        }
        bw.flush();
	}
}