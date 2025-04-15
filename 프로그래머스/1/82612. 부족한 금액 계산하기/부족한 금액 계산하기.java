class Solution {
    public long solution(int price, int money, int count) {
        long total;
        if(count%2==0) total=count/2*(count+1L);
        else total=(count+1)/2*(long) count;
        total=money-total*price;
        if(total>0) total=0;
        return -total;
    }
}