import java.io.*;
import java.util.*;

public class Main{
    static int total = 0;
    static int secret = 0;
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    String ISBN = br.readLine();
	    String[] nums = ISBN.split("");
	    int weight = 0;
	    for(int i=0;i<nums.length;i++){
	        if(i%2==0) weight = 1;
	        else weight = 3;
	        if(nums[i].equals("*")) {
	            secret = weight;
	            continue;
	        }
	        total+=Integer.parseInt(nums[i])*weight;
	    }
	    bw.write(findSecretNum()+"\n");
        bw.flush();
	}
	static int findSecretNum() {
	    if(total%10==0){
	        return 0;
	    }
	    for(int i=1;i<=9;i++){
	        if((total+secret*i)%10==0){
	            return i;
	        }
	    }
	    return -1;
	}
}