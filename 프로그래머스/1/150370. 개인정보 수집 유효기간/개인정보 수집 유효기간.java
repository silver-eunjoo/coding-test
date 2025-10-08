import java.util.*;

class Solution {
    Map<String, String> std;
    public String calcStdFromToday(String today, String terms) {
        StringTokenizer st = new StringTokenizer(today, ".");
        int year = Integer.parseInt(st.nextToken());
        int month = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());
        int months = Integer.parseInt(terms);
        
        day += 1;
        int newMonth = month - months;
        while(newMonth <= 0) {
            year--;
            if(newMonth == 0) {
                newMonth = 12;
            } else {
                newMonth = 12 + newMonth;
            }
        }
        return String.valueOf(year) + "." + String.valueOf(newMonth) + "." + String.valueOf(day);
    }
    public boolean compareWithStd(String date, String type) {
        String typeDate = std.get(type);
        System.out.println(typeDate);
        StringTokenizer st = new StringTokenizer(typeDate, ".");
        
        int tYear = Integer.parseInt(st.nextToken());
        int tMonth = Integer.parseInt(st.nextToken());
        int tDay = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(date, ".");
        int year = Integer.parseInt(st.nextToken());
        int month = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());
        
        if(tYear > year) return true;
        if(tYear < year) return false;
        if(tMonth > month) return true;
        if(tMonth < month) return false;
        if(tDay > day) return true;
        return false;
    }
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        List<Integer> result = new ArrayList<>();
        StringTokenizer st;
        std = new HashMap<>();
        for(int i=0;i<terms.length;i++){
            st = new StringTokenizer(terms[i]);
            std.put(st.nextToken(), calcStdFromToday(today, st.nextToken()));
        }
        for(int i=0;i<privacies.length;i++){
            st = new StringTokenizer(privacies[i]);
            if(compareWithStd(st.nextToken(), st.nextToken())) {
                result.add(i+1);
            }
        }
        answer = result.stream().mapToInt(i->i).toArray();
        return answer;
    }
}