import java.util.*;
import java.io.*;

public class Main {
    static int L;
    static int C;
    static char[] arr;
    static char[] result;
    static StringBuilder sb = new StringBuilder();
    static Set<Character> vowelSet = Set.of('a', 'e', 'i', 'o', 'u');
    private static void combination(int start, int depth, int vowel, int consonant) {
        if(depth == L) {
            if(vowel < 1 || consonant < 2) return;
            sb.append(String.valueOf(result)).append("\n");
            return;
        }
        
        for(int i=start;i<C;i++){
            int v = vowel;
            int c = consonant;
            if(vowelSet.contains(arr[i])) v++;
            else c++;
            result[depth] = arr[i];
            combination(i+1, depth+1, v, c);
        }
    }
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[C];
		result = new char[L];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<C;i++){
		    arr[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(arr);
		combination(0, 0, 0, 0);
		bw.write(sb.toString());
		bw.flush();
	}
}