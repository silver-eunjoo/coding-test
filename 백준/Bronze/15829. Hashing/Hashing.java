import java.io.*;
import java.util.*;

public class Main{
    private static final int R = 31;
    private static final int M = 1234567891;
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();
        long answer = 0L;
        for(int i=0;i<N;i++){
            int temp = input.charAt(i) - 96;
            answer+=temp * (long)Math.pow(R, i);
        }
        if(answer >= M) answer%=M;
        bw.write(String.valueOf(answer));
        bw.flush();
	}
}