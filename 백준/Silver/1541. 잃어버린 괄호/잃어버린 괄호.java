import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int total = 0;
		boolean minus = false;
		String input = br.readLine();
		for(int i=0;i<input.length();i++){
		    if(Character.isDigit(input.charAt(i))) sb.append(input.charAt(i));
		    else if(input.charAt(i)=='+') {
		        if(!minus) {
		            total+=Integer.parseInt(sb.toString());
		        } else {
		            total-=Integer.parseInt(sb.toString());
		        }
		        sb.setLength(0);
		    } else {
		        if(!minus) {
		            minus = true;
		            total+=Integer.parseInt(sb.toString());
		            sb.setLength(0);
		        }
		        else {
		            total-=Integer.parseInt(sb.toString());
		            sb.setLength(0);
		        }
		    }
		}
		if(minus) {
		    total-=Integer.parseInt(sb.toString());
		} else {
		    total+=Integer.parseInt(sb.toString());
		}
		bw.write(String.valueOf(total));
		bw.flush();
	}
}