import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		for(int i=0;i<N;i++){
		    st = new StringTokenizer(br.readLine());
		    for(int j=0;j<N;j++){
		        arr[i][j] = Integer.parseInt(st.nextToken());
		    }
		}
		for(int k=0;k<N;k++){
		    for(int i=0;i<N;i++){
		        for(int j=0;j<N;j++){
		            if(arr[i][k]==1&&arr[k][j]==1) {
		                arr[i][j] = 1;
		            }
		        }
		    }
		}
		for(int[] num : arr) {
		    for(int n : num) sb.append(n).append(" ");
		    sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}