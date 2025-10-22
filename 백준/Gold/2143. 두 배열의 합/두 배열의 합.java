import java.io.*;
import java.util.*;

public class Main {
    static List<Integer> bSum;
    public static int lowerBound(int target) {
        int left = 0;
        int right = bSum.size();
        while(left<right) {
            int mid = (left + right)/2;
            if(bSum.get(mid) < target) left = mid +1;
            else right = mid;
        }
        return left;
    }
    public static int upperBound(int target) {
        int left = 0;
        int right = bSum.size();
        while(left<right) {
            int mid = (left + right)/2;
            if(bSum.get(mid) <= target) left = mid+1;
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
        List<Integer> aSum = new ArrayList<>();
		for(int i=0;i<N;i++){
		    int sum = 0;
		    int idx = 0;
		    while(i+idx < N) {
		        sum+=A[i+idx];
		        aSum.add(sum);
		        idx++;
		    }
		}
		bSum = new ArrayList<>();
		for(int i=0;i<M;i++){
		    int sum = 0;
		    int idx = 0;
		    while(i+idx < M) {
		        sum+=B[i+idx];
		        bSum.add(sum);
		        idx++;
		    }
		}
		Collections.sort(bSum);
		long answer = 0;
		for(int a : aSum) {
		    int target = T - a;
		    answer += upperBound(target) - lowerBound(target);
		}
		bw.write(String.valueOf(answer));
		bw.flush();
	}
}