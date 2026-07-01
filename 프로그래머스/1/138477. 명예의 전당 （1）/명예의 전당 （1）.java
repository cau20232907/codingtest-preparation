import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        PriorityQueue<Integer> standing = new PriorityQueue<>();
        int[] result = new int[score.length];
        for(int i = 0; i < score.length; i++) {
            standing.add(score[i]);
            if (i >= k) {
                standing.poll();
            }
            result[i] = standing.peek();
        }
        return result;
    }
}