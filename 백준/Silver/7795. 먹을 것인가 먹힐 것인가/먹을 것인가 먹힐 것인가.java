import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		int[] A;
		int[] B;
		int left;
		while(T-->0) {
		    int answer = 0;
		    st = new StringTokenizer(br.readLine());
		    int N = Integer.parseInt(st.nextToken());
		    int M = Integer.parseInt(st.nextToken());
		    A = new int[N];
		    B = new int[M];
		    st = new StringTokenizer(br.readLine());
		    for(int i=0;i<N;i++){
		        A[i] = Integer.parseInt(st.nextToken());
		    }
		    st = new StringTokenizer(br.readLine());
		    for(int i=0;i<M;i++){
		        B[i] = Integer.parseInt(st.nextToken());
		    }
		    Arrays.sort(A);
		    Arrays.sort(B);
		    left = 0;
            for(int i=0;i<N;i++){
                while(left < M && A[i] > B[left]) {
                    left++;
                }
                answer+=left;
            }
            sb.append(answer+"\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}