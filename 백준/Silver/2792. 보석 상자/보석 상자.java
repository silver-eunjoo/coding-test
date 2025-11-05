import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] treasure = new int[M];
		int max = 0;
		for(int i=0;i<M;i++){
		    treasure[i] = Integer.parseInt(br.readLine());
		    max = Math.max(max, treasure[i]);
		}
		int left = 1;
		int right = max;
		long minJealousy = Long.MAX_VALUE;
		while(left<=right) {
		    int mid = (left+right)/2;
		    long jealousy = 0;
		    for(int i=0;i<M;i++) jealousy += (long)Math.ceil((double)treasure[i]/mid);
		    if(jealousy <= N) {
		        minJealousy = Math.min(minJealousy, mid);
		        right = mid - 1;
		    }
		    else left = mid + 1;
		}
		bw.write(String.valueOf(minJealousy));
		bw.flush();
	}
}