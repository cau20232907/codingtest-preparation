import java.util.Arrays;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] numOfUsersByStages=new int[N+2];
        //-1 연산 손실을 막기 위해 공간 하나 더 사용
        for(int i=0;i<stages.length;i++){
            numOfUsersByStages[stages[i]]++;
        }
        int[] numOfUsersByStagesSum=new int[N+1]; //누적(뒤에서부터)
        for(int i=N,sum=0;i>=0;i--){
            sum+=numOfUsersByStages[i+1];
            numOfUsersByStagesSum[i]=sum;
        System.out.print(sum+" ");
        }
        System.out.println();
        FailureRate[] failureRateForEachStage=
            new FailureRate[N];
        // 정렬 후 기존 순서만 가져오는 방법이 기억나지 않아, 약간 무식한 방법으로 진행
        for(int i=0;i<N;i++){
            failureRateForEachStage[i]=
                new FailureRate(i+1,
                    numOfUsersByStagesSum[i],
                    numOfUsersByStagesSum[i+1]);
            System.out.println(failureRateForEachStage[i]);
        }
        
        return Arrays.stream(failureRateForEachStage)
            .sorted()
            .mapToInt(rate->rate.stage).toArray();
    }
}

class FailureRate implements Comparable<FailureRate>{
    //getter, setter 생략
    public int stage;
    public double rate;
    
    FailureRate(int stage){
        this.stage=stage; //스테이지 번호
        this.rate=0;
    }
    
    FailureRate(int stage,
                                   int numOfUsersChallenged,
                                   int numOfUsersPassed){
        this.stage=stage; //스테이지 번호
        setRate(numOfUsersChallenged, numOfUsersPassed);
    }
    
    private void setRate(int numOfUsersChallenged,
                    int numOfUsersPassed){
        if(numOfUsersChallenged==0){
            this.rate=0;
        } else {
            this.rate=
                (double)(numOfUsersChallenged - numOfUsersPassed)
                / numOfUsersChallenged;
        }
    }
    
    public int compareTo(FailureRate object){
        int result = -1*Double.compare(this.rate,object.rate);
        if(result!=0) return result;
        else return Integer.compare(this.stage,object.stage);
    }
    
    @Override
    public String toString(){
        Double rate=this.rate;
        return "{"+stage+":"+rate.toString()+"}";
    }
}