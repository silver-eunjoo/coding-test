import java.io.*;
import java.util.*;

public class Main
{
	public static void main(String[] args) throws Exception{
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    
	    int n = Integer.parseInt(br.readLine());
	    int k = 0;
	    Long answer = 0L;
	    
	    while(n!=k) {
	        k++;
	        if(n%k == 0) {
	            answer+=n;
	        }else{
	            answer += (n/k)*k;
	        }
	    }
	    
	    bw.write(String.valueOf(answer));
	    br.close();
	    bw.flush();
	    bw.close();
	    
	    
	}
}