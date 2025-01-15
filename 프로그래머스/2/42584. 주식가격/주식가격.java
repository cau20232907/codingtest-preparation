import java.util.HashSet;
import java.util.Set;

class Solution {
    //1씩 움직인다는 가정이 들어 있음
    public int[] solution(int[] prices){
        int[] result=new int[prices.length];
        int currentStatus=prices[0];
        StartPointMapper[] firstIncresedIdx=new StartPointMapper[prices.length];
        firstIncresedIdx[0]=new StartPointMapper(0,currentStatus);
        int top=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]<currentStatus){
                while(top>=0&&firstIncresedIdx[top].value>prices[i]){
                    result[firstIncresedIdx[top].index]=
                        i-firstIncresedIdx[top].index;
                    top--;
                }
            }
            currentStatus=prices[i];
            firstIncresedIdx[++top]=new StartPointMapper(i,currentStatus);
        }
        while(top>=0){
            result[firstIncresedIdx[top].index]=
                prices.length-1-firstIncresedIdx[top].index;
            top--;
        }
        return result;
    }
}

//Getter 생략, 그냥 int 2개 묶음임
class StartPointMapper{
    int index;
    int value;
    StartPointMapper(int index, int value){
        this.index=index;
        this.value=value;
    }
    
    @Override
    public int hashCode(){
        return index*10000+value;
    }
}