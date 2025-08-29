import java.io.*;
import java.util.*;

public class Main{
    static int total = 0;
    static int secret = 0;
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    int N = Integer.parseInt(br.readLine());
	    int result = 0;
	    int start = Math.max(1, N-9*String.valueOf(N).length());
	    for(int i=start;i<N;i++){
	        int sum = i;
	        int tmp = i;
	        while(tmp > 0) {
	            sum += tmp%10;
	            tmp /= 10;
	        }
	        if(sum==N){
	            result=i;
	            break;
	        }
	    }
	    bw.write(String.valueOf(result));
	    bw.flush();
	}
}