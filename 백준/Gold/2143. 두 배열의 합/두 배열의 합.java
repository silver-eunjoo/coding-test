import java.io.*;
import java.util.*;

public class Main {
    static int[] bSum;
    public static int lowerBound(int target) {
        int left = 0;
        int right = bSum.length;
        while(left<right) {
            int mid = (left + right)/2;
            if(bSum[mid] < target) left = mid +1;
            else right = mid;
        }
        return left;
    }
    public static int upperBound(int target) {
        int left = 0;
        int right = bSum.length;
        while(left<right) {
            int mid = (left + right)/2;
            if(bSum[mid] <= target) left = mid+1;
            else right = mid;
        }
        return left;
    }
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++){
		    A[i] = Integer.parseInt(st.nextToken());
		}
		int M = Integer.parseInt(br.readLine());
		int[] B = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++){
		    B[i] = Integer.parseInt(st.nextToken());
		}
        int[] aSum = new int[(N*(N+1))/2];
        int idx = 0;
		for(int i=0;i<N;i++){
		    int sum = 0;
		    for(int j=0;i+j<N;j++){
		        sum+=A[i+j];
		        aSum[idx++] = sum;
		    }
		}
		bSum = new int[(M*(M+1))/2];
		idx = 0;
		for(int i=0;i<M;i++){
		    int sum = 0;
		    for(int j=0;i+j<M;j++){
		        sum+=B[i+j];
		        bSum[idx++] = sum;
		    }
		}
		Arrays.sort(bSum);
		long answer = 0;
		for(int a : aSum) {
		    int target = T - a;
		    answer += upperBound(target) - lowerBound(target);
		}
		bw.write(String.valueOf(answer));
		bw.flush();
	}
}