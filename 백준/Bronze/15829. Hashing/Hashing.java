import java.io.*;
import java.util.*;

public class Main{
    private static final int R = 31;
    private static final int M = 1234567891;
    private static long power = 1;
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();
        long answer = 0L;
        for(int i=0;i<N;i++){
            int temp = input.charAt(i) - 96;
            if(i==0) {
                answer+=temp * power;    
                continue;
            }
            power = (power*R)%M;
            answer = (answer+ temp*power) % M;
        }
        bw.write(String.valueOf(answer));
        bw.flush();
	}
}