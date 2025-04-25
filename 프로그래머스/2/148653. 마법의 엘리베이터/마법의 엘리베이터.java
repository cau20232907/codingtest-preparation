class Solution {
    public int solution(int storey) {
        int answer = 0;
        boolean isLastDigit5=false;
        while(storey!=0){
            byte lastDigit=(byte) (storey%10);
            storey/=10;
            if(lastDigit<=4){ //(~(lastDigit&0x4))==0
                isLastDigit5=false;
                answer+=lastDigit;
            }else if(lastDigit==5&&!isLastDigit5){
                isLastDigit5=true;
                answer+=lastDigit; //5
            }else{
                if(isLastDigit5) lastDigit++;
                isLastDigit5=false;
                answer+=(10-lastDigit);
                storey++;
            }
        }
        return answer;
    }
}