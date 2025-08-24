import java.io.*;
import java.util.*;

public class Main
{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        
        String mul = Integer.toString(A*B*C);
        
        List<String> nums = Arrays.asList(mul.split(""));
        
        for(int i=0;i<10;i++){
            bw.write(Collections.frequency(nums, String.valueOf(i)) + "\n");
        }
        bw.flush();
	}
}