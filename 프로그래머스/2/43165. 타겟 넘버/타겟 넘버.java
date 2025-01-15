class Solution {
    public int solution(int[] numbers, int target) {
        return calculateStep(numbers, new byte[numbers.length], target, 0);
    }
    
    private int calculateStep(int[] numbers, byte[] current, int target, int step){
        if(step==numbers.length){ //일치하는지 계산
            int total=0;
            for(int i=0;i<numbers.length;i++){
                total+=current[i]*numbers[i]; //current는 부호임
            }
            if(total==target) return 1;
            else return 0;
        }else{ //연산자 설정 후 다음 step 진행
            int answer=0;
            current[step]=1;
            answer=calculateStep(numbers, current, target, step+1);
            current[step]=-1;
            answer+=calculateStep(numbers, current, target, step+1);
            //current[step]=0;
            return answer;
        }
    }
}