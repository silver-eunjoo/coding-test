import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int idx = 1;
        int cnt = 0;
        while(N>=Math.pow(5, idx)) {
            cnt += N/Math.pow(5, idx);
            idx++;
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
	}
}