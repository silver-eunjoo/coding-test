import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] fluid = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++){
		    fluid[i] = Integer.parseInt(st.nextToken());
		}
		int left = 0;
		int right = N-1;
	    long absNum = Long.MAX_VALUE;
		int[] answer = new int[2];
		while(left<right) {
		    long composite = fluid[left] + fluid[right];
		    if(Math.abs(composite) < absNum) {
		        answer[0] = fluid[left];
		        answer[1] = fluid[right];
		        absNum = Math.abs(composite);
		    } 
		    if(composite < 0) left++;
		    else right--;
		}
    	sb.append(answer[0]).append(" ").append(answer[1]);
		bw.write(sb.toString());
		bw.flush();
	}
}