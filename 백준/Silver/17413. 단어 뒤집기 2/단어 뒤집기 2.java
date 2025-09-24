import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String input = br.readLine();
        Stack<Character> stack = new Stack<>();
        boolean flip = true;
        for(int i=0;i<input.length();i++){
            if(flip && input.charAt(i)==' ') {
                while(!stack.empty()) {
                    sb.append(stack.pop());
                }
                sb.append(" ");
            }
            else if(input.charAt(i)=='<') {
                flip = false;
                while(!stack.empty()) {
                    sb.append(stack.pop());
                }
                sb.append('<');
            } else {
                if(flip) stack.push(input.charAt(i));
                else sb.append(input.charAt(i));
            }
            if(input.charAt(i)=='>') {
                flip = true;
            }
        }
        while(!stack.empty()) {
            sb.append(stack.pop());
        }
        bw.write(sb.toString());
        bw.flush();
	}
}