import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int M;
    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    static int[] result;
    static boolean[] visited;
    private static void repeatCombination(int start, int depth) {
        if(depth==M) {
            for(int i=0;i<M;i++){
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        int prev = -1;
        for(int i=start;i<N;i++){
            if(prev==arr[i]) continue;
            result[depth] = arr[i];
            prev = arr[i];
            repeatCombination(i, depth+1);
        }
    }
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		result = new int[M];
		visited = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++){
		    arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		repeatCombination(0, 0);
		bw.write(sb.toString());
		bw.flush();
	}
}
