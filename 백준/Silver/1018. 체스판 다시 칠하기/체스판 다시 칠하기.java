import java.util.*;
import java.io.*;

public class Main {
    static char[][] chess;
    private static int countColor(int x, int y, char startColor) {
        int count = 0;
        for(int i=x;i<x+8;i++){
            for(int j=y;j<y+8;j++){
                char expected = (i+j)%2==0?startColor:opposite(startColor);
                if(chess[i][j]!=expected) count++;
            }
        }
        return count;
    }
    private static char opposite(char color) {
        return color=='W'?'B':'W';
    }
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		chess = new char[N][M];
		for(int i=0;i<N;i++){
		    String input = br.readLine();
		    for(int j=0;j<M;j++){
		        chess[i][j] = input.charAt(j);
		    }
		}
		int min = Integer.MAX_VALUE;
		for(int i=0;i<=N-8;i++){
		    for(int j=0;j<=M-8;j++){
		        int W = countColor(i, j, 'W');
		        int B = countColor(i, j, 'B');
		        min = Math.min(min, Math.min(W, B));
		    }
		}
		bw.write(String.valueOf(min));
		bw.flush();
	}
}