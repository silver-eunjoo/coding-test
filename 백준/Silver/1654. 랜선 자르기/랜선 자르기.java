import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] line = new int[N];
		int max = 0;
		for(int i=0;i<N;i++){
		    line[i] = Integer.parseInt(br.readLine());
		    max = Math.max(max, line[i]);
		}
		long left = 1;
		long right = max;
		long total = 0;
		while(left<=right) {
		    long mid = (left+right)/2;
		    long cnt = 0;
		    for(int i=0;i<N;i++) cnt+=line[i]/mid;
		    if(cnt>=K) {
		        total = Math.max(total, mid);
		        left = mid +1;
		    } else right = mid - 1;
		}
		bw.write(String.valueOf(total));
		bw.flush();
	}
}