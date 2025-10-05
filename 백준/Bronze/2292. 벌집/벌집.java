import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int idx = 1;
        if(N==1){
            bw.write("1");
            bw.flush();
            return;
        }
        else N-=1;
        while(N>6*idx) {
            N-=6*idx;
            idx++;
        }
        bw.write(idx+1+"\n");
        bw.flush();
	}
}