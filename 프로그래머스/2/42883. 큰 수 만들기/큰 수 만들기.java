import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder answer=new StringBuilder();
        int i=0;
        while(k>0&&i+k<number.length()){
            int maxVal=IntStream.range(i,k+i+1)
                .map(number::charAt)
                .max().getAsInt();
            while(number.charAt(i)!=maxVal) {
                i++;
                k--;
            }
            answer.append((char) maxVal);
            i++;
        }
        if(k==0&&i<number.length())
            return answer+number.substring(i);
        else return answer.toString();
    }
}
//해당 digit에서 가능한 범위 탐색
//이중 가장 높은 수가 나오도록 지우기