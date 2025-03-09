import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] arr) {
        Map<Integer,Integer> maxDivided=new HashMap<>();
        Arrays.stream(arr).mapToObj(i->{
            Map<Integer,Integer> divided=new HashMap<>();
            for(int j=2;j<Math.sqrt(i)+1;j++){
                while(i%j==0){
                    divided.put(j,divided.getOrDefault(j,0)+1);
                    i/=j;
                }
            }
            if(i!=1) divided.put(i,1);
            return divided;
        }).collect(Collectors.toList()) //동시성 문제로 일단 collect
            .forEach(divided->{
                divided.entrySet().stream()
                .forEach(e->{
                    if(!maxDivided.containsKey(e.getKey())||
                       maxDivided.get(e.getKey())<e.getValue())
                        maxDivided.put(e.getKey(),e.getValue());
                });
        });
        return maxDivided.entrySet().stream()
            .mapToInt(e->{
                int v=e.getKey();
                for(int i=1;i<e.getValue();i++)
                    v*=e.getKey();
                return v;
            })
            .reduce((i,j)->i*j)
            .getAsInt();
    }
}