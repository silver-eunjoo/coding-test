import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int N = Integer.parseInt(br.readLine());
        while(N-->0) {
            int num = Integer.parseInt(br.readLine());
            if(num==0) stack.pop();
            else stack.push(num);
        }
        int sum = 0;
        while(!stack.empty()) sum+=stack.pop();
        bw.write(String.valueOf(sum));
        bw.flush();
	}
}