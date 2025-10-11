import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		StringBuilder answer = new StringBuilder();
		Stack<Character> stack;
		while(true) {
		    stack = new Stack<>();
		    sb.setLength(0);
		    sb.append(br.readLine());
		    if(sb.toString().equals(".")) break;
		    boolean valid = true;
		    for(int i=0;i<sb.length();i++){
		        if(sb.charAt(i)=='(' || sb.charAt(i)=='[') stack.push(sb.charAt(i));
		        else if(sb.charAt(i)==')') {
		            if(stack.size()>0 && stack.peek()=='(') stack.pop();
		            else{
		                valid = false;
		                break;
		            } 
		        } else if(sb.charAt(i)==']') {
		            if(stack.size()>0 && stack.peek()=='[') stack.pop();
		            else {
		                valid = false;
		                break;
		            }
		        }
		    }
		    if(stack.size()==0 && valid) answer.append("yes\n");
		    else answer.append("no\n");
		}
		bw.write(answer.toString());
		bw.flush();
	}
}