import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] numbers) {
        TreeMap<Integer,Set<Integer>> numbersIdx=new TreeMap<>();
        int[] answer=new int[numbers.length];
        for(int i=0;i<numbers.length;i++){
            int current=numbers[i];
            answer[i]=-1;
            while(!numbersIdx.isEmpty()){
                int num=numbersIdx.firstKey();
                if(num>=current) break;
                for(int idx:numbersIdx.get(num))
                    answer[idx]=current;
                numbersIdx.remove(num);
            }
            if(numbersIdx.containsKey(current))
                numbersIdx.get(current).add(i);
            else{
                Set<Integer> temp=new HashSet<>();
                temp.add(i);
                numbersIdx.put(current,temp);
            }
        }
        return answer;
    }
}