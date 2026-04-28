import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> passedWithSkill = new PriorityQueue<>();
        for(int i = 0; i < enemy.length; i++) {
            passedWithSkill.add(enemy[i]);
            if (passedWithSkill.size() > k) {
                n -= passedWithSkill.poll();
                if (n < 0) {
                    return i;
                }
            }
        }
        return enemy.length;
    }
}