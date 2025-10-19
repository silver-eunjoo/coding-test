import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		int prev = 0;
		for(int i=1;i<=N;i++){
		    int target = Integer.parseInt(br.readLine());
		    if(stack.isEmpty()) {
		        if(prev>target) {
		            sb.setLength(0);
                    sb.append("NO");
                    bw.write(sb.toString());
                    bw.flush();
                    return;
		        }
		        for(int j=prev+1;j<=target;j++){
		            stack.push(j);
		            sb.append("+\n");
		        }
		        stack.pop();
		        sb.append("-\n");
		    } else {
		        if(stack.peek() > target) {
		            while(true) {
		                if(stack.isEmpty() || stack.peek() < target) {
		                    sb.setLength(0);
		                    sb.append("NO");
		                    bw.write(sb.toString());
		                    bw.flush();
		                    return;
		                }
		                int num = stack.pop();
		                sb.append("-\n");
		                if(num==target) break;
		            }
		        } else if(stack.peek() < target) {
		            for(int j=prev+1;j<=target;j++){
		                stack.push(j);
		                sb.append("+\n");
		            }
		            stack.pop();
		            sb.append("-\n");
		        } else {
		            stack.pop();
		            sb.append("-\n");
		        }
		    }
		    prev = Math.max(prev, target);
		    
		}
		bw.write(sb.toString());
		bw.flush();
	}
}