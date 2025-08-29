import java.io.*;
import java.util.*;

public class Main{
    static int total = 0;
    static int secret = 0;
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    int N = Integer.parseInt(br.readLine());
	    int num = 0;
	    for(int i=1;i<N;i++){
	        num+=i;
	        String[] nums = Integer.toString(i).split("");
	        for(int j=0;j<nums.length;j++){
	            num+=Integer.parseInt(nums[j]);
	        }
	        if(num==N) {
	            num=i;
	            break;
	        }
	        num=0;
	    }
	    bw.write(String.valueOf(num));
	    bw.flush();
	}
}