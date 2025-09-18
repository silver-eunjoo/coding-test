import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String input;
        int left = 0;
        int right = 0;
        while(!(input = br.readLine()).equals("0")) {
            left = 0;
            right = input.length()-1;
            while(left<=right) {
                if(input.charAt(left)!=(input.charAt(right))){
                    sb.append("no\n");
                    break;
                } else {
                    left++;
                    right--;
                }
            }
            if(left>=right) sb.append("yes\n");
        }
        bw.write(sb.toString());
        bw.flush();
	}
}