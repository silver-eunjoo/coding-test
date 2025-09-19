import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        while(N-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();
            if(command.equals("push")) {
                stack.push(Integer.parseInt(st.nextToken()));
            } else if(command.equals("pop")) {
                if(stack.isEmpty()) sb.append("-1\n");
                else sb.append(stack.pop() + "\n");
            } else if(command.equals("size")) {
                sb.append(stack.size() + "\n");
            } else if(command.equals("empty")) {
                if(stack.isEmpty()) sb.append("1\n");
                else sb.append("0\n");
            } else {
                if(stack.isEmpty()) sb.append("-1\n");
                else sb.append(stack.peek() + "\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
	}
}