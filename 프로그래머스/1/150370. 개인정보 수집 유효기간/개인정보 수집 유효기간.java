import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        long todayLong=dateToInt(today);
        long[] term=new long[26];
        for(int i=0;i<terms.length;i++)
            term[terms[i].charAt(0)-'A']=Integer.parseInt(terms[i].substring(2))*28L;
        List<Integer> answer=new ArrayList<>();
        for(int i=0;i<privacies.length;){
            String[] splits=privacies[i].split(" ");
            i++;
            if(dateToInt(splits[0])+term[splits[1].charAt(0)-'A']<=todayLong)
                answer.add(i);
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    private long dateToInt(String date){
        String[] splits=date.split("\\.");
        long answer=(Long.parseLong(splits[1])-1)*28+Long.parseLong(splits[2])-1;
        return (Long.parseLong(splits[0])-2000)*12*28+answer;
    }
}