import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = 666;
        int cnt = 1;
        int N = Integer.parseInt(br.readLine());
        while(cnt < N) {
            num++;
            if(String.valueOf(num).contains("666")) cnt++;
        }
        bw.write(String.valueOf(num));
        bw.flush();
	}
}