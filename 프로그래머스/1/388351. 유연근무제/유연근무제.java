class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        for (int i = 0; i < schedules.length; i++) {
            int schedule = (schedules[i] / 100) * 60 + (schedules[i] % 100) + 10;
            boolean keptTime = true;
            
            for (int j = 0; keptTime && j < timelogs[i].length; j++) {
                int day = (startday + j) % 7;
                if (day == 6 || day == 0) {
                    continue;
                }
                
                int timelog = (timelogs[i][j] / 100) * 60 + (timelogs[i][j] % 100);
                if (schedule < timelog) {
                    keptTime = false;
                }
            }
            
            if (keptTime) {
                answer++;
            }
        }
        return answer;
    }
}