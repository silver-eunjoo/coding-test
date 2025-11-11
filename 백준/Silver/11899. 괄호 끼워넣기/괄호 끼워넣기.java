import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Character> stack = new Stack<>();
		String input = br.readLine();
		for(int i=0;i<input.length();i++){
		    if(!stack.isEmpty() && stack.peek()=='(' && input.charAt(i)==')') stack.pop();
		    else stack.push(input.charAt(i));
		}
		bw.write(String.valueOf(stack.size()));
		bw.flush();
	}
}