class Solution {
    public int solution(int n) {
        int[] mem=new int[]{0,1};
        while(n>1){
            mem[0]=(mem[0]+mem[1])%1234567;
            mem[1]=(mem[0]+mem[1])%1234567;
            n-=2;
        }
        return mem[n];
    }
}