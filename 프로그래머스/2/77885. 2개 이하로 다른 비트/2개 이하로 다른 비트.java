class Solution {
    public long[] solution(long[] numbers) {
        for(int i=0;i<numbers.length;i++){
            long number=numbers[i]; //성능을 위해 빼둠
            for(long j=1;j>0;j<<=1)
                if((number&j)==0){
                    numbers[i]=(number|j)&(~(j>>1));
                    break;
                }
        }
        return numbers;
    }
}