import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Map<Integer, List<String>> people = new HashMap<>();
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            List<String> names = people.getOrDefault(age, new ArrayList<>());
            names.add(name);
            people.put(age, names);
        }
        Map<Integer, List<String>> sorted = new TreeMap<>(people);
        for(Integer i : sorted.keySet()){
            for(String n : sorted.get(i)) {
                bw.write(i + " " + n + "\n");
            }
        }
        bw.flush();
	}
}