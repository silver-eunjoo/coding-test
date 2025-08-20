import java.io.*;
import java.util.*;

public class Main
{
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		
		Arrays.fill(arr, Integer.MAX_VALUE);
		
		String line = br.readLine();
		
		StringTokenizer st = new StringTokenizer(line, " ");
		
		for(int i=1;i<=N;i++){
		    int num = Integer.parseInt(st.nextToken());
		    
		    for(int j=0;j<N;j++){
		        
		        if(arr[j] > i) {
		            num--;
		        }
		        
		        if(num<0 && arr[j] == Integer.MAX_VALUE){
		            arr[j] = i;
		            break;
		        }
		        
		    }
		}
		
		for(int i=0;i<N;i++){
		    bw.write(String.valueOf(arr[i]) + " ");
		}
		
		bw.flush();
		
	}
}