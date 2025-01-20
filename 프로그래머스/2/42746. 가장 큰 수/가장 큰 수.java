import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(int[] numbers) {
        if(Arrays.stream(numbers).allMatch(i->i==0)) return "0"; //"00"이 반환되면 안됨
        else return Arrays.stream(numbers).mapToObj(Integer::toString)
            .sorted((i,j)->Integer.compare(Integer.parseInt(j+i),
                                           Integer.parseInt(i+j)))
            .collect(Collectors.joining(""));
    }
}