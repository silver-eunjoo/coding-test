import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int M;
    static int count = 0;
    static boolean[] visited;
    static List<Integer>[] computer;
    private static void dfs(int start) {
        for(int i=0;i<computer[start].size();i++){
            int next = computer[start].get(i);
            if(visited[next]) continue;
            count++;
            visited[next] = true;
            dfs(next);
        }
    }
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		computer = new ArrayList[N+1];
		visited = new boolean[N+1];
		for(int i=1;i<=N;i++){
		    computer[i] = new ArrayList<>();
		}
		M = Integer.parseInt(br.readLine());
		while(M-->0) {
		    st = new StringTokenizer(br.readLine());
		    int c1 = Integer.parseInt(st.nextToken());
		    int c2 = Integer.parseInt(st.nextToken());
		    computer[c1].add(c2);
		    computer[c2].add(c1);
		}
		visited[1] = true;
		dfs(1);
		bw.write(String.valueOf(count));
		bw.flush();
	}
}