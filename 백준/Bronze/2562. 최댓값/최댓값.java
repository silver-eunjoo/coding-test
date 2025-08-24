import java.io.*;
import java.util.*;
public class Main
{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        List<Integer> numList = new ArrayList<>();
        
        for(int i=0;i<9;i++){
            numList.add(Integer.parseInt(br.readLine()));
        }
        
        int max = Collections.max(numList);
        bw.write(max + "\n");
        bw.write(numList.indexOf(max) + 1 + "\n");
        bw.flush();
    }
}