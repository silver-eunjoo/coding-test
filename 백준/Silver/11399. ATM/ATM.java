import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int i=0;i<N;i++){
		    arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int waitTime = 0;
		int total = 0;
		for(int num: arr) {
		    waitTime += num;
		    total+=waitTime;
		}
		bw.write(String.valueOf(total));
		bw.flush();
	}
}