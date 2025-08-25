import java.io.*;
import java.util.*;
public class Main
{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        
        for(int i=0;i<N;i++){
            int D = Integer.parseInt(br.readLine());
            String line = br.readLine();
            st = new StringTokenizer(line, " "); 
            
            int[] price = new int[D];
            
            for(int j=0;j<D;j++){
                price[j] = Integer.parseInt(st.nextToken());
            }
            
            long profit = 0;
            int maxPrice = price[D-1];
            for(int j=D-2;j>=0;j--) {
                if(price[j] < maxPrice) {
                    profit += maxPrice - price[j];
                } else {
                    maxPrice = price[j];
                }
            }
            bw.write(profit + "\n");
        }
        bw.flush();
    }
}