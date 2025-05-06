import java.io.*;
import java.util.*;

public class Main{
    
    public static int[] isPrimeNum = new int[1000001];
    
    public static int isPrime(int num){
        if(num == 1){
            return 0;
        }
        
        if(isPrimeNum[num] != -1){
            return isPrimeNum[num];
        }
        
        for(int i=2;i<=(int)Math.sqrt(num);i++){
            if(num%i==0){
                isPrimeNum[num] = 0;
                return 0;
            }   
        }
        
        isPrimeNum[num] = 1;
        return 1;
    }
    
    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        Arrays.fill(isPrimeNum, -1);
        
        String line;
        while(!((line = br.readLine()).equals("0"))){
            int num = Integer.parseInt(line);
            int i=3;
            for(;i<=num/2;i=i+2){ // 두 홀수 소수 !!
                if((num-i)%2==1){ // 홀수
                    if((isPrime(i)==1) && (isPrime(num-i) == 1)){
                        bw.write(num + " = " + i + " + " + (num-i) + "\n");
                        break;
                    }
                }
            }
            if(i>num/2){
                bw.write("Goldbach's conjection is wrong.\n");
            }
        }
        
        
        br.close();
        bw.flush();
        bw.close();
        
    }
}