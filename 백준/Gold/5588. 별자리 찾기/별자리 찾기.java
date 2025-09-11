import java.io.*;
import java.util.*;

public class Main{
    static class Point {
        int x, y;
        Point(int x, int y) { 
            this.x = x; 
            this.y = y; 
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Point)) return false;
            Point p = (Point) o;
            return x == p.x && y == p.y;
        }
    
        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        List<int[]> stars = new ArrayList<>();
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            stars.add(new int[]{x, y});
        }
        int N = Integer.parseInt(br.readLine());
        Set<Point> pics = new HashSet<>();
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            pics.add(new Point(x, y));
        }
        int idx = 0;
        int dx = 0;
        int dy = 0;
        int[] star;
        for(Point p : pics) {
            star = stars.get(idx);
            dx = p.x - star[0];
            dy = p.y - star[1];
            for(idx=1;idx<M;idx++){
                star = stars.get(idx);
                Point temp = new Point(star[0]+dx, star[1]+dy);
                if(pics.contains(temp)) continue;
                else {
                    idx = 0;
                    break;
                }
            }
            if(idx==M) break;
        }
        bw.write(dx + " " + dy);
        bw.flush();
	}
}