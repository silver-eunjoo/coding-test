import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] count = new int[100001];
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		int max = 0;
		int left = 0;
		for(int i=0;i<N;i++){
		    int num = Integer.parseInt(st.nextToken());
		    arr[i] = num;
		    count[num]++;
	        while(count[num] > K) {
	            count[arr[left]]--;
	            left++;
	        }
	        max = Math.max(max, i-left+1);
		}
		bw.write(String.valueOf(max));
		bw.flush();
	}
}