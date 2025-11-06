import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int S = Integer.parseInt(br.readLine());
		String input = br.readLine();
		int count = 0;
		int patternCount = 0;
		for(int i=1;i<S-1;i++){
		    if(input.charAt(i-1)=='I' && input.charAt(i)=='O' && input.charAt(i+1)=='I') {
		        patternCount++;
		        i++;
		        if(patternCount==N) {
		            count++;
		            patternCount--;
		        }
		    } else {
		        patternCount=0;
		    }
		}
		bw.write(String.valueOf(count));
		bw.flush();
	}
}