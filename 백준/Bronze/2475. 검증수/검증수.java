import java.io.*;

public class Main
{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String line = br.readLine();
        String[] numbers = line.split(" ");
        int total = 0;
        
        for(int i=0;i<5;i++){
            total+=Math.pow(Integer.parseInt(numbers[i]), 2);
        }
        
        bw.write(String.valueOf(total%10));
        bw.flush();
    }
}