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
            
            List<Integer> price = new ArrayList<>();
            
            for(int j=0;j<D;j++){
                price.add(Integer.parseInt(st.nextToken()));
            }
            
            bw.write(getMaxProfit(price) + "\n");
        }
        
        bw.flush();
    }
    
    static long getMaxProfit(List<Integer> price) {
        long profit = 0;
        int size = price.size();
        int maxPrice = price.get(size-1);
        for(int i=size-2;i>=0;i--){
            if(price.get(i) < maxPrice) {
                profit += maxPrice - price.get(i);
            } else if(price.get(i) > maxPrice) {
                maxPrice = price.get(i);
            }
        }
        return profit;
    }
}