import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] count = new int[7];
		Set<Integer> set = new HashSet<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<3;i++){
		    int num = Integer.parseInt(st.nextToken());
		    set.add(num);
		    count[num]++;
		}
		if(set.size()==3) {
		    bw.write(String.valueOf(Collections.max(set)*100));
		} else if(set.size()==1) {
		    for(int num: set) {
		        bw.write(String.valueOf(10000+num*1000));
		    }
		} else {
		    int prev = 0;
		    int same = 0;
		    for(int num:set) {
		        if(prev < count[num]) {
		            prev = count[num];
		            same = num;
		        }
		    }
		    bw.write(String.valueOf(1000+same*100));
		}
		bw.flush();
	}
}