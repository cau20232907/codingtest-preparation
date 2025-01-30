import java.util.Arrays;

class Solution {
    public String solution(String s) {
        int[] numbers=Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
        int max=numbers[0],min=numbers[0];
        for(int i=1;i<numbers.length;i++){
            if(numbers[i]<min) min=numbers[i];
            if(numbers[i]>max) max=numbers[i];
        }
        String answer = min+" "+max;
        return answer;
    }
}