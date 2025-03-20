class Solution {
    public int solution(int n) {
        n--;
        int i=2;
        while(n%i!=0) i++;
        return i;
    }
}