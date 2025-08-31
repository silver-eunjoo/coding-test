import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int result = 1;
        for(int i=0;i<K;i++){
            result*=N--;
        }
        while(K>0){
            result/=K--;
        }
        bw.write(String.valueOf(result));
        bw.flush();
	}
}