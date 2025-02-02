class Solution {
    public int solution(int n) {
        //세로로만 배치할 수 있음
        //이 중 몇 개를 가로로 돌릴 수 있음
        // 1: 1
        // 2: 2
        // 3: 3
        // 4: 5
        // 5: 8
        // 6:13
        //... fibonacci???
        int[] mem=new int[]{1,1};
        while(n>1){ //n&0x7FFFFFFC!=0으로 써도 되긴 함
            mem[0]=(mem[0]+mem[1])%1000000007;
            mem[1]=(mem[0]+mem[1])%1000000007;
            n-=2;
        }
        return mem[n];
    }
}