import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static final int O = 3;
    static char[][] aisle;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static StringBuilder sb = new StringBuilder();
    static boolean found = false;
    static List<int[]> teachers = new ArrayList<>();
    private static boolean checkStudents() {
        for(int[] t : teachers) {
            for(int i=0;i<4;i++){
                int nx = t[0];
                int ny = t[1];
                while(true) {
                    nx += dx[i];
                    ny += dy[i];
                    if(nx < 0 || ny < 0 || nx >= N || ny >= N) break;
                    if(aisle[nx][ny]=='O') break;
                    else if(aisle[nx][ny]=='S') return false;
                }
            }
        }
        return true;
    }
    private static void avoidTeachers(int depth, int start) {
        if(found) return;
        if(depth == O) {
            if(checkStudents()) found = true;
            return;
        }
        for(int i = start;i<N*N;i++){
            int r = i/N;
            int c = i%N;
            if(aisle[r][c] != 'X') continue;
            aisle[r][c] = 'O';
            avoidTeachers(depth + 1, i + 1);
            aisle[r][c] = 'X';
        }
    }
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		aisle = new char[N][N];
		for(int i=0;i<N;i++){
		    st = new StringTokenizer(br.readLine());
		    for(int j=0;j<N;j++){
		        aisle[i][j] = st.nextToken().charAt(0);
		        if(aisle[i][j]=='T') teachers.add(new int[]{i, j});
		    }
		}
		avoidTeachers(0, 0);
		bw.write(found?"YES":"NO");
		bw.flush();
	}
}