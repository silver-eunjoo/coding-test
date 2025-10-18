import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int M;
    static boolean[] visited;
    static int[] selected;
    static StringBuilder sb = new StringBuilder();
    public static void permutation(int depth) {
        if(depth==M) {
            for(int num : selected) sb.append(num + " ");
            sb.append("\n");
            return;
        }
        
        for(int i=1;i<=N;i++){
            if(visited[i]) continue;
            visited[i] = true;
            selected[depth] = i;
            permutation(depth+1);
            visited[i] = false;
        }
    }
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N+1];
		selected = new int[M];
		permutation(0);
		bw.write(sb.toString());
		bw.flush();
	}
}