import java.io.*;
import java.util.*;

public class Main
{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        Set<Integer> rem = new HashSet<>();
        
        for(int i=0;i<10;i++){
            rem.add(Integer.parseInt(br.readLine())%42);
        }
        
        bw.write(String.valueOf(rem.size()));
        bw.flush();
	}
}