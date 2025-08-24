import java.io.*;
public class Main
{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        int total = 0;
        String line = br.readLine();
        String[] nums = line.split("");
        
        for(int i=0;i<N;i++){
            total+=Integer.parseInt(nums[i]);
        }
        bw.write(String.valueOf(total));
        bw.flush();
    }
}