import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int M;
    static int[] selected;
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void permutation(int depth) {
        if(depth==M) {
            for(int num : selected) sb.append(num + " ");
            sb.append("\n");
            return;
        }
        
        for(int i=0;i<N;i++){
            if(visited[i]) continue;
            visited[i] = true;
            selected[depth] = arr[i];
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
		selected = new int[M];
		visited = new boolean[N];
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++){
		    arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		permutation(0);
		bw.write(sb.toString());
		bw.flush();
	}
}