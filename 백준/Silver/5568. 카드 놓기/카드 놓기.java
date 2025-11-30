import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int K;
    static int arr[];
    static int result[];
    static boolean visited[];
    static Set<Integer> set = new HashSet<>();
    private static void arrayToNum() {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<K;i++){
            sb.append(result[i]);
        }
        set.add(Integer.parseInt(sb.toString()));
    }
    private static void permutation(int depth) {
        if(depth==K) {
            arrayToNum();
            return;
        }
        for(int i=0;i<N;i++){
            if(visited[i]) continue;
            visited[i] = true;
            result[depth] = arr[i];
            permutation(depth + 1);
            visited[i] = false;
        }
    }
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		arr = new int[N];
		result = new int[K];
		visited = new boolean[N];
		for(int i=0;i<N;i++){ 
		    arr[i] = Integer.parseInt(br.readLine());
		}
		permutation(0);
		bw.write(String.valueOf(set.size()));
		bw.flush();
	}
}
