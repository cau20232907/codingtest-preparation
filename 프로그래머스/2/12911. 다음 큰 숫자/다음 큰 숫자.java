class Solution {
    public int solution(int n) {
        int bitCursor=1;
        while((n&bitCursor)==0) bitCursor<<=1;
        n&=(~bitCursor); //처음으로 1을 만나면 0으로 변경
        bitCursor<<=1;
        int downCursor=1;
        while((n&bitCursor)!=0){
            //이후 1을 만나면 1->0, 아랫자리 0->1
            n&=(~bitCursor);
            n|=downCursor;
            bitCursor<<=1;
            downCursor<<=1;
        }
        n|=bitCursor; //마지막 자리수 0->1
        //byte[]를 쓰면 시간초과 발생
        return n;
    }
}