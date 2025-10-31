import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input = br.readLine().split("-");
		int total = 0;
		for(int i=0;i<input.length;i++){
		     String[] splited = input[i].split("\\+");
		     int sum = 0;
		     for(String num : splited) {
		         sum+=Integer.parseInt(num);
		     }
		     if(i==0) total+=sum;
		     else total-=sum;
		}
		bw.write(String.valueOf(total));
		bw.flush();
	}
}