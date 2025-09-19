import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> q = new ArrayDeque<>();
        int num = 0;
        while(N-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();
            if(command.equals("push")) {
                q.offer(Integer.parseInt(st.nextToken()));
            } else if(command.equals("pop")) {
                sb.append(q.isEmpty()?"-1\n":q.poll()+"\n");
            } else if(command.equals("size")) {
                sb.append(q.size() + "\n");
            } else if(command.equals("empty")) {
                sb.append(q.isEmpty()?"1\n":"0\n");
            } else if(command.equals("front")){
                sb.append(q.peekFirst()!=null?q.peekFirst()+"\n":"-1\n");
            } else {
                sb.append(q.peekLast()!=null?q.peekLast()+"\n":"-1\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
	}
}