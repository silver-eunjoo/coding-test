import java.io.*;
import java.util.*;

public class Main{
    static List<Integer>[] famList;
    static boolean[] visited;
    static int end;
    static int dfs(int now) {
        if(visited[now]) return -1;
        visited[now] = true;
        if(now == end) {
            return 0;
        }
        for(int i=0;i<famList[now].size();i++) {
            int result = dfs(famList[now].get(i));
            if(result != -1) return result +1;
        }
        return -1;
    }
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        famList = new ArrayList[N+1];
        visited = new boolean[N+1];
        for(int i=0;i<=N;i++){
            famList[i] = new ArrayList<>();
        }
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine());
        while(M-->0) {
            st = new StringTokenizer(br.readLine(), " ");
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            famList[parent].add(child);
            famList[child].add(parent);
        }
        int result = dfs(start);
        bw.write(String.valueOf(result));
        bw.flush();
	}
}