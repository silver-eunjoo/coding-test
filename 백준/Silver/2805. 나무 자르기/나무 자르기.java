import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] tree = new int[N];
		int max = 0;
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++){
		    tree[i] = Integer.parseInt(st.nextToken());
		    max = Math.max(max, tree[i]);
		}
		int left = 1;
		int right = max;
		int maxLength = 0;
		while(left<=right) {
		    int mid = (left+right)/2;
		    long len = 0;
		    for(int i=0;i<N;i++) {
		        int cut = tree[i] - mid;
		        if(cut>0) len+=cut;
		    }
		    if(len>=M) {
		        maxLength = Math.max(maxLength, mid);
		        left = mid +1;
		    } else right = mid - 1;
		}
		bw.write(String.valueOf(maxLength));
		bw.flush();
	}
}