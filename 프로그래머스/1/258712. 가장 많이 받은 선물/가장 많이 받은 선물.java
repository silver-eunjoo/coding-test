import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        Map<String, Integer> people = new HashMap<>();
        int N = friends.length;
        int[][] hist = new int[N][N];
        int[][] cnt = new int[N][2]; // [i][0] 준 선물, [i][1] 받은 선물
        int[] score = new int[N];
        int[] result = new int[N];
        for(int i=0;i<N;i++){
            people.put(friends[i], i);
        }
        StringTokenizer st;
        for(String gift : gifts) {
            st = new StringTokenizer(gift);
            int giver = people.get(st.nextToken());
            int receiver = people.get(st.nextToken());
            hist[giver][receiver]++;
            cnt[giver][0]++;
            cnt[receiver][1]++;
        }
        for(int i=0;i<N;i++){
            score[i] = cnt[i][0] - cnt[i][1];
        }
        for(int i=0;i<N;i++){
            for(int j=i+1;j<N;j++){
                if(hist[i][j] < hist[j][i]) result[j]++;
                else if(hist[j][i] < hist[i][j]) result[i]++;
                else if(hist[i][j] == hist[j][i]) {
                    if(score[i] < score[j]) result[j]++;
                    else if(score[j] < score[i]) result[i]++;
                }
            }
        }
        for(int i=0;i<N;i++){
            answer = Math.max(result[i], answer);
        }
        return answer;
    }
}