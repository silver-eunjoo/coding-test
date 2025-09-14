import java.io.*;
import java.util.*;

public class Main{
    static Map<String, String[]> idol;
    static StringBuilder sb;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        idol = new HashMap<>();
        while(N-->0) {
            String group = br.readLine();
            int K = Integer.parseInt(br.readLine());
            String[] members = new String[K];
            for(int i=0;i<K;i++){
                String member = br.readLine();
                members[i] = member;
            }
            idol.put(group, members);
        }
        while(M-->0) {
            String q = br.readLine();
            int type = Integer.parseInt(br.readLine());
            if(type==1){ // 1 이면 -> 어느 그룹인지 찾아야 함.
                findGroup(q);
                continue;
            }
            findMembers(q);
        }
        bw.write(sb.toString());
        bw.flush();
	}
	static void findGroup(String q) {
	    for(Map.Entry<String, String[]> entry : idol.entrySet()) {
	        for(String member : entry.getValue()) {
                if(member.equals(q)) {
                    sb.append(entry.getKey() + "\n");
                    return;
                }
	        }
	    }
	}
	static void findMembers(String q) {
	    for(String key : idol.keySet()) {
	        if(key.equals(q)) {
	            String[] members = idol.get(key);
	            Arrays.sort(members);
	            for(String member : members) {
                    sb.append(member+"\n");
	            }
	            return;
	        }
	    }
	}
}