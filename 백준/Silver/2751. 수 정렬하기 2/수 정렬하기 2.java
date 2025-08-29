import java.io.*;
import java.util.*;

public class Main{
    static int total = 0;
    static int secret = 0;
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    int N = Integer.parseInt(br.readLine());
	    int[] arr = new int[N];
	    for(int i=0;i<N;i++){
	        arr[i]=Integer.parseInt(br.readLine());
	    }
	    Arrays.sort(arr);
	    for(int i=0;i<N;i++){
	        bw.write(arr[i]+"\n");    
	    }
	    bw.flush();
	}
}