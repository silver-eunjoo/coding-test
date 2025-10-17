import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] nums = br.readLine().split("");
		Set<Integer> set = new HashSet<>();
		int cnt = 0;
		while(true) {
		    int N = nums.length;
		    boolean left = false;
		    set.clear();
		    for(int i=0;i<N;i++){
    		    int target = Integer.parseInt(nums[i]);
    		    if(target==-1) continue;
    		    left = true;
    		    if(!set.contains(target)) {
    		        set.add(target);
    		        nums[i] = "-1";
    		    } else {
    		        if((target == 6 && !set.contains(9)) || (target == 9 && !set.contains(6))) {
    		            set.add(6);
    		            set.add(9);
    		            nums[i] = "-1";
    		        }
    		    }
    		}
    		if(!left) break;
    		cnt++;
		}
		bw.write(String.valueOf(cnt));
		bw.flush();
	}
}