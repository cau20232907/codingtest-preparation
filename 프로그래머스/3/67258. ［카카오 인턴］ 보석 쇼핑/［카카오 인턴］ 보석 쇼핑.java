import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        Map<String, Integer> lastPos = new HashMap<>();
        TreeMap<Integer, String> posLast = new TreeMap<>();
        
        lastPos.put(gems[0], 0);
        posLast.put(0, gems[0]);
        int[] answer = new int[2];
        answer[0] = 0;
        answer[1] = 0;
        
        for(int i = 1; i < gems.length; i++) {
            String currentGem = gems[i];
            if (lastPos.containsKey(currentGem)) {
                posLast.remove(lastPos.get(currentGem));
                lastPos.put(currentGem, i);
                posLast.put(i, currentGem);
                int leastStart = posLast.firstKey();
                if (i - leastStart < answer[1] - answer[0]) {
                    answer[0] = leastStart;
                    answer[1] = i;
                }
            } else {
                lastPos.put(currentGem, i);
                posLast.put(i, currentGem);
                answer[0] = posLast.firstKey();
                answer[1] = i;
            }
        }
        
        answer[0]++;
        answer[1]++;
        return answer;
    }
}