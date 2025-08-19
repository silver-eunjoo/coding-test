import java.io.*;
import java.util.*;

public class Main
{
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line = br.readLine();
		
		StringTokenizer st = new StringTokenizer(line, " ");
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		if(a==b) {
		    bw.write("==");    
		} else if(a>b) {
		    bw.write(">");
		} else {
		    bw.write("<");
		}
		
        bw.flush();
	}
}