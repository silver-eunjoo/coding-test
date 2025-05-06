import java.io.*;
import java.util.*;

public class Main{
    
    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int[] heights = new int[9];
        int total = 100;
        
        for(int i=0;i<9;i++){
            heights[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(heights);
        
        for(int i=0;i<9;i++){
            for(int j=1;j<9;j++){
                for(int k=2;k<9;k++){
                    for(int m =3;m<9;m++){
                        for(int l=4;l<9;l++){
                            for(int n=5;n<9;n++){
                                for(int o = 6; o<9;o++){
                                    if(heights[i]+heights[j]+heights[k]+heights[m]+heights[l]+heights[n]+heights[o] == 100){
                                        bw.write(heights[i]+"\n");
                                        bw.write(heights[j]+"\n");
                                        bw.write(heights[k]+"\n");
                                        bw.write(heights[m]+"\n");
                                        bw.write(heights[l]+"\n");
                                        bw.write(heights[n]+"\n");
                                        bw.write(heights[o]+"\n");
                                        br.close();
                                        bw.flush();
                                        bw.close();
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        
        
        
    }
}