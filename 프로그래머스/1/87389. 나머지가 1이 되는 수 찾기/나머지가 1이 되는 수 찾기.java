class Solution {
    public int solution(int n) {
        n--;
        int i=2;
        while(true){
            if(n%i==0) return i;
            i++;
        }
    }
}