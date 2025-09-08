import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> frequency = new HashMap<>();
        for(int i=0;i<N;i++){
            int num = Integer.parseInt(br.readLine());
            list.add(num);
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }
        Collections.sort(list);
        int frequent = 0;
        for(Integer key : frequency.keySet()) {
            frequent = Math.max(frequent, frequency.get(key));
        }
        int[] f = new int[N];
        int idx = 0;
        Arrays.fill(f, Integer.MAX_VALUE);
        for(Integer key : frequency.keySet()) {
            if(frequency.get(key) == frequent) {
                f[idx++] = key;
            }
        }
        sb.append(Math.round((double)list.stream().mapToInt(i->i).sum()/N) + "\n");
        sb.append(list.get(N/2) + "\n");
        if(idx==1) {
            sb.append(f[0] + "\n");
        } else {
            Arrays.sort(f);
            sb.append(f[1] + "\n");
        }
        sb.append((Collections.max(list)-Collections.min(list)) + "\n");
        bw.write(sb.toString());
        bw.flush();
	}
}