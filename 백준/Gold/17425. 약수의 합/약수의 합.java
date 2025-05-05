import java.io.*;
import java.util.*;

public class Main
{
    public static final int MAX_NUM = 1000001;
    
	public static void main(String[] args) throws Exception{
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    
	    long[] f = new long[MAX_NUM]; // f[x]는 x의 약수의 합
	    long[] g = new long[MAX_NUM]; // g[x]는 x보다 작거나 같은 모든 자연수 y의 f[y]를 더한 값
	    
	    Arrays.fill(f, 1);
	    
	    // i*j의 약수 x에 대하여 범위는 i*j (곱이 최대 약수)으로 제한
	    for(int i=2;i<MAX_NUM;i++){
	        for(int j=1;j*i<MAX_NUM;j++){
	            f[i*j] += i;
	        }
	    }
	    
	    for(int i=1;i<MAX_NUM;i++){
	        g[i] = g[i-1] + f[i];
	    }
	    
	    int num = Integer.parseInt(br.readLine());
	    for(int i=0;i<num;i++){
	        int n = Integer.parseInt(br.readLine());
	        bw.write(g[n]+"\n");
	    }
	    
	    br.close();
	    bw.flush();
	    bw.close();
	    
	    
	}
}