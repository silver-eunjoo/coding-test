import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Map<Integer, String> numToName = new HashMap<>();
		Map<String, Integer> nameToNum = new HashMap<>();
		for(int i=0;i<N;i++){
		    String monster = br.readLine();
		    numToName.put(i+1, monster);
		    nameToNum.put(monster, i+1);
		}
		while(M-->0) {
		    String input = br.readLine();
		    if(Character.isDigit(input.charAt(0))) { // 숫자로 들어오면
		        sb.append(numToName.get(Integer.parseInt(input))+"\n");
		    } else {
		        sb.append(nameToNum.get(input)+"\n");
		    }
		}
		bw.write(sb.toString());
		bw.flush();
	}
}