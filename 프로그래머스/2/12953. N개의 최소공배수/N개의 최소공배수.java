import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] arr) {
        return Arrays.stream(arr).mapToObj(i->{
            Map<Integer,Integer> divided=new HashMap<>();
            for(int j=2;j<Math.sqrt(i)+1;j++)
                while(i%j==0){
                    divided.put(j,divided.getOrDefault(j,0)+1);
                    i/=j;
                }
            if(i!=1) divided.put(i,1);
            return divided;
        }).flatMap(m->m.entrySet().stream())
            .collect(Collectors.groupingBy(Map.Entry::getKey,
                Collectors.mapping(Map.Entry::getValue,
                    Collectors.maxBy(
                        Comparator.comparingInt(i->i)))))
            .entrySet().stream()
            .mapToInt(e->{
                int k=e.getKey(), v=k;
                for(int i=e.getValue().get()-1;i>0;i--)
                    v*=k;
                return v;
            })
            .reduce((i,j)->i*j)
            .getAsInt();
    }
}