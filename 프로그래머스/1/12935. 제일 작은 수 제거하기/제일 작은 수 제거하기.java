class Solution {
    public int[] solution(int[] arr) {
        if (arr.length == 1) {
            return new int[]{-1};
        }
        
        int minPos = 0;
        int minNum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < minNum) {
                minPos = i;
                minNum = arr[i];
            }
        }
        int[] answer = new int[arr.length - 1];
        System.arraycopy(arr, 0, answer, 0, minPos);
        System.arraycopy(arr, minPos + 1, answer, minPos, answer.length - minPos);
        return answer;
    }
}