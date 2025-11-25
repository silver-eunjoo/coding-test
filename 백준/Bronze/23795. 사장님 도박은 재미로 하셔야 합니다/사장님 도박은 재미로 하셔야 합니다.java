import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String input;
		int sum = 0;
		while(!(input=br.readLine()).equals("-1")) {
		    sum += Integer.parseInt(input);
		}
		bw.write(String.valueOf(sum));
		bw.flush();
	}
}