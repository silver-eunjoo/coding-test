import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int M;
    static int[] arr;
    static int[] output;
    static boolean[] visited;
    static int max = 0;
    static int stage = 0;
    static int result = 0;
    private static int calc() {
        int sum = 0;
        for(int i=0;i<N-1;i++){
            sum+=Math.abs(output[i] - output[i+1]);
        }
        return sum;
    }
    private static void permutation(int depth) {
        if(depth==N) {
            result = calc();
            max = Math.max(max, result);
            return;
        }
        for(int i = 0;i<N;i++){
            if(visited[i]) continue;
            visited[i] = true;
            output[depth] = arr[i];
            permutation(depth+1);
            visited[i] = false;
        }
    }
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N];
		visited = new boolean[N];
		output = new int[N];
		for(int i=0;i<N;i++){
		    arr[i] = Integer.parseInt(st.nextToken());
		}
		permutation(0);
		bw.write(String.valueOf(max));
		bw.flush();
	}
}