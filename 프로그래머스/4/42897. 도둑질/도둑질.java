class Solution {
    public int solution(int[] money) {
        // Status[] statuses=new Status[money.length];
        // statuses[0]=new Status(money[0],true);
        // statuses[1]=new Status(money[1],false);
        Status maxExcBef=new Status(money[0],true); //직전 제외 최대
        Status tempStatus1=new Status(money[1],false);
        Status maxIncBef=maxExcBef; //직전 포함 최대 idx
        if(money[0]<=money[1]) maxIncBef=tempStatus1;
        
        //첫번째 미포함 직전 제외 최대 idx, 길이가 4 이하이면 예외처리 필요
        Status maxExcFirst=null;
        //직전이 첫번째 미포함일 시 임시 저장 공간(다음 loop에 처리)
        Status befExcFirst=tempStatus1;
        for(int i=2;i<money.length-1;i++){
            Status current=new Status(maxExcBef.money+money[i],
                                      maxExcBef.includedFirst);//연산
            
            //첫번째 미포함 처리
            if(maxExcBef!=maxExcFirst||maxExcFirst!=befExcFirst){
                //둘 다 같으면 이미 밖의 처리가 안과 같으므로 중복 처리 필요 없음
                Status excfirst=current;
                if(current.includedFirst){
                    if(maxExcFirst==null) excfirst=null; //연산 결과 없음
                    else excfirst=new Status(maxExcFirst.money+money[i],false);//연산
                }
                
                //직전값 이관
                //maxExcFirst, befExcFirst 중 큰 값 maxExcFirst에 저장
                if(maxExcFirst==null||(befExcFirst!=null&&
                    maxExcFirst.money<befExcFirst.money))
                    maxExcFirst=befExcFirst;
                befExcFirst=excfirst; //현재 값
            }
            
            //일반 처리(첫번째 미포함 처리와 선후관계 상관없음)
            maxExcBef=maxIncBef; //직전값 이관
            //포함 최댓값 적용
            if(maxIncBef.money<current.money||
              (maxIncBef.money==current.money&&
                    maxIncBef.includedFirst)) //동순위시 includedFirst 없는 쪽
                maxIncBef=current;
            
            if(maxExcBef==maxExcFirst&&maxExcFirst==befExcFirst){
                //이후로도 같은 조건 유지할 수 있게 유지만 진행해 줌
                maxExcFirst=maxExcBef;
                befExcFirst=maxExcBef;
            }
        }
        int temp = Math.max(maxIncBef.money, //마지막 뺀 것
             maxExcBef.money-money[0]+money[money.length-1]); //마지막 포함하고 처음을 뺌
        if(maxExcFirst!=null) return Math.max(temp,
                    maxExcFirst.money+money[money.length-1]); //처음이 제외되어 있는 것
        else return temp;
    }
    
    private class Status{
        final int money;
        final boolean includedFirst;
        Status(int money, boolean includedFirst){
            this.money=money;
            this.includedFirst=includedFirst;
        }
    }
}
//연속으로만 불가능함
//원형이므로 첫번째에 대해서 특별한 처리 필요
//저장해야 하는 최댓값: 직전 포함, 직전 제외, 첫번째 미포함 직전 제외(첫번째 미포함이어도 직전 포함이면 마지막 원소를 더할 수 없음)