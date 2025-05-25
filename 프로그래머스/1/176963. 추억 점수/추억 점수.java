import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        Map<String, Integer> points=new HashMap<>();
        for(int i=0;i<name.length;i++){
            points.put(name[i],yearning[i]);
        }
        return Arrays.stream(photo)
            .mapToInt(p->
                Arrays.stream(p)
                    .mapToInt(m->
                        points.getOrDefault(m,0)
                    ).sum()
            ).toArray();
    }
}