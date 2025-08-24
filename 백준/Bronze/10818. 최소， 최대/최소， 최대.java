import java.io.*;
import java.util.*;
public class Main
{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        List<Integer> numList = new ArrayList<>();
        
        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line, " ");
        
        for(int i=0;i<N;i++){
            numList.add(Integer.parseInt(st.nextToken()));
        }
        
        bw.write(Collections.min(numList) + " " + Collections.max(numList));
        bw.flush();
    }
}