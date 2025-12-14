import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		Set<String> company = new TreeSet<>(Collections.reverseOrder());
		String[] input;
		while(N-->0) {
		    input = br.readLine().split(" ");
		    if(input[1].equals("leave")) company.remove(input[0]);
		    else company.add(input[0]);
		}
		for(String name: company) {
		    sb.append(name).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}