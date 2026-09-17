import java.util.*;

class Solution {
    public int solution(int[] cards) {
        PriorityQueue<Integer> scores = new PriorityQueue<>(Collections.reverseOrder());
        boolean[] visited = new boolean[cards.length];
        for (int i = 0; i < cards.length; i++) {
            if (visited[i]) {
                continue;
            }
            int currentScore = 1;
            int currentNum = cards[i] - 1;
            visited[i] = true;
            while (!visited[currentNum]) {
                visited[currentNum] = true;
                currentNum = cards[currentNum] - 1;
                currentScore++;
            }
            scores.add(currentScore);
        }
        int maxScore = scores.poll();
        int nextScore = 0;
        if (!scores.isEmpty()) {
            nextScore = scores.poll();
        }
        return maxScore * nextScore;
    }
}