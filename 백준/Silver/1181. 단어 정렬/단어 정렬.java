import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String[] inputs = new String[N];
        for(int i=0;i<N;i++){
            inputs[i] = br.readLine();
        }
        Arrays.sort(inputs, Comparator.comparingInt(String::length)
                                        .thenComparing(Comparator.naturalOrder()));
        bw.write(inputs[0]+"\n");
        for(int i=1;i<N;i++){
            if(inputs[i-1].equals(inputs[i])) continue;
            bw.write(inputs[i] + "\n");
        }
        bw.flush();
	}
}