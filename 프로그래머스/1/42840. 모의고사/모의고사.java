class Solution {
    public int[] solution(int[] answers) {
        int[] score=new int[3];
        for(int questionNum=0;questionNum<answers.length;questionNum++){
            if(answers[questionNum]==questionNum%5+1) score[0]++;
            switch(questionNum%8){
                case 2:
                case 4:
                case 6:
                case 0:
                    {
                        if(answers[questionNum]==2) score[1]++;
                        break;
                    }
                case 1:{
                    if(answers[questionNum]==1) score[1]++;
                    break;
                }
                case 3:{
                    if(answers[questionNum]==3) score[1]++;
                    break;
                }
                case 5:{
                    if(answers[questionNum]==4) score[1]++;
                    break;
                }
                case 7:{
                    if(answers[questionNum]==5) score[1]++;
                    break;
                }
            }
            switch(questionNum/2%5){
                case 0:{
                    if(answers[questionNum]==3) score[2]++;
                    break;
                }
                case 1:{
                    if(answers[questionNum]==1) score[2]++;
                    break;
                }
                case 2:{
                    if(answers[questionNum]==2) score[2]++;
                    break;
                }
                case 3:{
                    if(answers[questionNum]==4) score[2]++;
                    break;
                }
                case 4:{
                    if(answers[questionNum]==5) score[2]++;
                    break;
                }
            }
        }
        boolean[] tmp=new boolean[score.length];
        int max=score[0];
        int numOfTie=1;
        tmp[0]=true;
        for(int i=1;i<score.length;i++){
            if(score[i]>max){
                max=score[i];
                for(int j=0;j<i;j++)
                    tmp[j]=false;
                tmp[i]=true;
                numOfTie=1;
            }
            else if(score[i]==max){
                tmp[i]=true;
                numOfTie++;
            }
            else tmp[i]=false;
        }
        int[] result=new int[numOfTie];
        int nextIdx=0;
        for(int i=0;i<tmp.length;i++){
            if(tmp[i]) result[nextIdx++]=i+1;
        }
        return result;
    }
}