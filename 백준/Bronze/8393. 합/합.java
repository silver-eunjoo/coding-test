import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int total = 0;
		for(int i=1;i<=N;i++){
		    total+=i;
		}
		bw.write(String.valueOf(total));
		bw.flush();
	}
}