import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Set<Integer> set = new HashSet<>();
        while(M-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();
            int num;
            switch(command) {
                case "add" : 
                    num = Integer.parseInt(st.nextToken());
                    set.add(num);
                    break;
                case "remove" :
                    num = Integer.parseInt(st.nextToken());
                    set.remove(num);
                    break;
                case "check" : 
                    num = Integer.parseInt(st.nextToken());
                    sb.append(set.contains(num)?"1\n":"0\n");
                    break;
                case "toggle" : 
                    num = Integer.parseInt(st.nextToken());
                    if(set.contains(num)){
                        set.remove(num);
                    } else set.add(num);
                    break;
                case "all" :
                    for(int i=1;i<=20;i++){
                        set.add(i);
                    }
                    break;
                case "empty" : 
                    set.clear();
                    break;
            }
        }
        bw.write(sb.toString());
        bw.flush();
	}
}