import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        for(int i=0,j=0,k=0,l=0;i<board.length-answer;i++)
            for(j=0;j<board[i].length-answer;){
                if(board[i][j]==0) j++;
                else if(board[i][j]<0) j-=board[i][j];
                //*-1 값만큼 넘기라는 의미(최댓값 갱신 불가)
                else{
                    int size=board[i][j]-1;
                    boolean flag=true;
                    do{
                        size++;
                        if(i+size>=board.length){//바닥 도달, 추가 연산 불필요
                            answer = Math.max(answer,size);
                            return answer*answer;
                            //크기가 최소 1이므로 -1 필요 없음(이미 포함됨)
                        }
                        if(j+size>=board[i].length) {
                            //skip sign은 board[i].length-answer로 처리됨
                            j=Integer.MAX_VALUE-1; //다음 i로 진행
                            break;
                        }
                        
                        //확인
                        for(k=0;k<=size;k++){
                            if(board[i+k][j+size]==0) { //가로가 막힘
                                flag=false;
                                for(l=1;l<=k;l++){ //skip sign
                                    if(board[i+l][j]!=0)
                                        board[i+l][j]=(-(size+1));
                                    //i+l을 시작으로 하는, 이보다 큰 사각형은
                                    //존재할 수 없음
                                }
                                for(l=k+1;l<size;l++){
                                    if(board[i+l][j]>0)
                                        board[i+l][j]=size-l; //confirmed sign
                                }
                                j+=size-1; //skip
                                break;
                            }else if(board[i+size][j+k]==0){
                                flag=false;
                                for(l=0;l<=size;l++){ //skip sign
                                    if(board[i+l][j]!=0)
                                        board[i+l][j]=(-(k+1));
                                    //해당 위치를 지나가면서 이후로 이보다 큰 사각형은
                                    //존재할 수 없음
                                }
                                if(size-k>1){ //&0x7FFFFFFE!=0과 동일
                                    for(l=0;l<size;l++){ //confirmed sign
                                        if(board[i+l][j+k+1]==1)
                                            board[i+l][j+k+1]=
                                                Math.min(size-l,size-k-1);
                                    }
                                }
                                j+=k; //skip
                                break;
                            }
                        }
                    } while(flag);
                    answer=Math.max(answer,size);
                    j++;
                }
            }
        return answer*answer;
    }
}

/*
가로가 막히면 건너뛰기
세로가 막히면...

3 2 1 1 1
2 2 1 1 1
1 1 1 1 1
0 1 1 1 1
0 1 1 1 1

가로가 막히면 가로 skip sign (-n)
세로가 막히면 세로 skip sign
가로는 맨 앞에만 써서 skip시키면 되는데 세로는 전부 작성 필요
가능한 부분에는 몇*몇인지 써놓기..?
*/