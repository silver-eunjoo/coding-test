import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int[][] people = new int[N][2];
	    for(int i=0;i<N;i++){
	        st = new StringTokenizer(br.readLine());
	        people[i][0] = Integer.parseInt(st.nextToken());
	        people[i][1] = Integer.parseInt(st.nextToken());
	    }
	    for(int i=0;i<N;i++){
	        int cnt = 0;
	        for(int j=0;j<N;j++){
	            if(i==j) continue;
	            if(people[i][0] < people[j][0] && people[i][1] < people[j][1]) cnt++;
	        }
	        sb.append(++cnt + " ");
	    }
	    bw.write(sb.toString());
        bw.flush();
	}
}