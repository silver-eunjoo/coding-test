import java.io.*;

public class Main
{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String number = br.readLine();
		
		int zero = 0;
		int one = 0;
		
		String[] nums = number.split("");
		
		String standard = nums[0];
		
		for(String num : nums) {
		    if(!standard.equals(num)) {
		        if(String.valueOf(0).equals(num)) {
		            one++;
		        } else {
		            zero++;
		        }
		        standard = num;
		    }
		}
		
		if(standard.equals("0")) {
		    zero++;
		} else {
		    one++;
		}
		
		bw.write(String.valueOf(Math.min(zero, one)));
		
		bw.flush();
	}
}