import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        Set<Integer> winSet = new HashSet<>();
        for(int i = 0; i < win_nums.length; i++) {
            winSet.add(win_nums[i]);
        }
        int unknown = 0;
        int correct = 0;
        for(int i = 0; i < lottos.length; i++) {
            if (lottos[i] == 0) {
                unknown++;
            } else if (winSet.contains(lottos[i])) {
                correct++;
            }
        }
        return new int[]{
            Math.min(6, 7 - (unknown + correct)),
            Math.min(6, 7 - correct)
        };
    }
}