class Solution {
    public int solution(String str1, String str2) {
        boolean answer = str1.contains(str2);
        if(answer) return 1;
        return 2;
    }
}