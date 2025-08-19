import java.io.*;

public class Main
{
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		
		int num1 = a * (b%10);
		int num2 = a * ((b/10)%10);
		int num3 = a * (b/100);
		
		bw.write(String.valueOf(num1) + "\n");
		bw.write(String.valueOf(num2) + "\n");
		bw.write(String.valueOf(num3) + "\n");
		
		bw.write(String.valueOf(num1 + 10*num2 + 100*num3));
		
        bw.flush();
	}
}