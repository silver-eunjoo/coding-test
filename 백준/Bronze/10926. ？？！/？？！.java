import java.io.*;
import java.util.*;

public class Main
{
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String name = br.readLine();
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(name).append("??!");
		
		bw.write(sb.toString());
        bw.flush();
	}
}