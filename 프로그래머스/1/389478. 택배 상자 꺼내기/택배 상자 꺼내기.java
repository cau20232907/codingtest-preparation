class Solution {
    public int solution(int n, int w, int num) {
        num--;
        final int height=(n/w);
        final int numPos=num/w;
        int numAcrpos=(num%w);
        if((height+numPos)%2==1){
            //XOR
            numAcrpos=w-1-numAcrpos;
        }
        int answer=height-numPos;
        if(numAcrpos<(n%w)) answer++;
        return answer;
    }
}