import java.util.*;
class Solution {
    private final int[] DISCOUNT = {10, 20, 30, 40};
    int[] rate;
    int N;
    List<Integer> result = new ArrayList<>(List.of(0,0));
    
    public void repeatPermutation(int depth, int[][] users, int[] emoticons) {
        if(depth == N) {
            calc(users, emoticons);
            return;
        }
        
        for(int i=0;i<4;i++){
            rate[depth] = DISCOUNT[i];
            repeatPermutation(depth+1, users, emoticons);
        }
    }
    public void calc(int[][] users, int[] emoticons) {
        List<Integer> temp = new ArrayList<>(List.of(0, 0));
        for(int i=0;i<users.length;i++){
            int pay = 0;
            for(int j=0;j<N;j++){
                if(users[i][0] > rate[j]) continue;
                if(pay >= users[i][1]) break;
                pay += emoticons[j] * (100-rate[j]) / 100;
            }
            if(pay >= users[i][1]) {
                temp.set(0, temp.get(0) + 1);
                continue;
            }
            temp.set(1, temp.get(1) + pay);
        }
        if(result.get(0) == temp.get(0) && result.get(1) < temp.get(1)) {
            result.set(1, temp.get(1));
            return;
        }
        if(result.get(0) < temp.get(0)) {
            result.set(0, temp.get(0));
            result.set(1, temp.get(1));
            return;
        }
    }
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = {};
        N = emoticons.length;
        rate = new int[N];
        
        repeatPermutation(0, users, emoticons);
        answer = result.stream().mapToInt(i->i).toArray();
        
        return answer;
    }
}