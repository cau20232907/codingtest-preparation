class Solution {
    public String solution(String s) {
        int middlePoint = s.length()/2;
        if (s.length()%2 == 1) {
            return s.substring(middlePoint, middlePoint+1);
        } else {
            return s.substring(middlePoint-1, middlePoint+1);
        }
    }
}