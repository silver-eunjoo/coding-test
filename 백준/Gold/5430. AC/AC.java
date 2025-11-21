import java.util.*;
import java.io.*;

public class Main {
    static char[] command;
    static int M;
    static int N;
    static Deque<Integer> numDeque;
    static StringBuilder sb;
    private static void func() {
        boolean reversed = false;
        for(int i=0;i<M;i++){
            if(command[i]=='R') {
                reversed = !reversed;
                continue;
            }
            if(numDeque.size()!=0) {
                if(!reversed) numDeque.pollFirst();
                else numDeque.pollLast();
                continue;
            }
            sb.append("error\n");
            return;
        }
        sb.append("[");
        int size = numDeque.size();
        for(int i=0;i<size;i++){
            if(!reversed) sb.append(numDeque.pollFirst());
            else sb.append(numDeque.pollLast());
            if(i<size-1) sb.append(",");
        }
        sb.append("]\n");
    }
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		while(T-->0) {
		    String input = br.readLine();
		    M = input.length();
		    command = new char[M];
		    for(int i=0;i<input.length();i++) {
		        command[i] = input.charAt(i);
		    }
		    N = Integer.parseInt(br.readLine());
		    st = new StringTokenizer(br.readLine(), "[,]");
		    numDeque = new ArrayDeque<>();
		    for(int i=0;i<N;i++){
		        numDeque.offer(Integer.parseInt(st.nextToken()));
		    }
		    func();
		}
		bw.write(sb.toString());
		bw.flush();
	}
}