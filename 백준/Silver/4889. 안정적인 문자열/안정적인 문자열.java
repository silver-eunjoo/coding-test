import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        int idx = 0;
        int count = 0;
        while(true) {
            idx++;
            count=0;
            stack = new Stack<>();
            String input = br.readLine();
            if(input.charAt(0)=='-') break;
            for(int i=0;i<input.length();i++){
                if(input.charAt(i)=='}'){
                    if(stack.size()!=0 && stack.peek()=='{') stack.pop();
                    else stack.push(input.charAt(i));
                } else stack.push(input.charAt(i));
            }
            if(stack.empty()) sb.append(idx + ". 0\n");
            else {
                while(!stack.empty()) {
                    char prev = stack.pop();
                    char c = stack.pop();
                    if(c==prev) count++;
                    else count+=2;
                }
                sb.append(idx+ ". "+count+"\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
	}
}