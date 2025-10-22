import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		while(true){
		    String input = br.readLine();
		    if(input.charAt(0)=='#') break;
		    input = input.toLowerCase();
		    int count = 0;
		    for(int i=2;i<input.length();i++){
		        if(input.charAt(0)==input.charAt(i)) count++;
		    }
		    sb.append(input.charAt(0) + " " + count + "\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}