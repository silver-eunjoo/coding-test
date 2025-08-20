import java.io.*;
import java.util.*;

public class Main
{
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		
		String line = br.readLine();
	    st = new StringTokenizer(line, " ");
	    
	    int N = Integer.parseInt(st.nextToken());
	    int mix = Integer.parseInt(st.nextToken());
	    
	    line = br.readLine();
	    st = new StringTokenizer(line, " ");
	    
	    long[] cards = new long[N];
	    
	    for(int i=0;i<N;i++){
	        cards[i] = Long.parseLong(st.nextToken());
	    }
	    
	    for(int i=0;i<mix;i++){
	        Arrays.sort(cards);
	        
	        long sum = cards[0] + cards[1];
	        
	        cards[0] = sum;
	        cards[1] = sum;
	    }
	    
	    bw.write(String.valueOf(Arrays.stream(cards).sum()));
		
		bw.flush();
		
	}
}