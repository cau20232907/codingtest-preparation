class Solution {
    boolean solution(String s) {
        int numOfOpened=0;
        for(int idx=0;idx<s.length();idx++){
            switch(s.charAt(idx)){
                case '(': {
                    numOfOpened++;
                    break;
                }
                case ')': {
                    numOfOpened--;
                    if(numOfOpened<0) return false;
                    break;
                }
                default: throw new RuntimeException();
            }
        }
        return numOfOpened==0;
    }
}