import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int K = Integer.parseInt(br.readLine());
        int length = (int)Math.pow(2, K)-1;
        int[] arr = new int[length];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<length;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int level = 1;
        sb.append(arr[length/2]+"\n");
        for(;level<K;level++){
            int idx = (int)Math.pow(2, K-1-level)-1;
            idx = idx<0 ? 0 : idx;
            int gap = (int)Math.pow(2, K - level);
            while(idx<length) {
                sb.append(arr[idx]).append(" ");
                idx+=gap;
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
	}
}