import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Stack<Character> stack = new Stack<>();
        while(N-->0) {
            stack = new Stack<>();
            String input = br.readLine();
            for(int i=0;i<input.length();i++){
                if(input.charAt(i)=='(') stack.push(input.charAt(i)); 
                else {
                    if(stack.size()!=0 && stack.peek()=='(') stack.pop();
                    else stack.push(input.charAt(i));
                }
            }
            if(stack.size()!=0) sb.append("NO\n");
            else sb.append("YES\n");
        }
        bw.write(sb.toString());
        bw.flush();
	}
}