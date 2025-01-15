import java.util.ArrayDeque;

class Solution {
    
    ArrayDeque<int[]> myStep=new ArrayDeque<>();
    ArrayDeque<int[]> opponentStep=new ArrayDeque<>();
    int[][] mapStatus;
    
    public int solution(int[][] maps) {
        int result;
        mapStatus=maps;
        mapStatus[mapStatus.length-1][mapStatus[mapStatus.length-1].length-1]=-1; //뒷쪽은 -1, -2,...으로 진행
        
        if(mapStatus.length>=2) {
            result=checkAndSetPositive(new int[]{0,0},new int[]{1,0});
            if(result!=0) return result;
            checkAndSetNegative(new int[]{mapStatus.length-1,mapStatus[mapStatus.length-1].length-1},
                                new int[]{mapStatus.length-2,mapStatus[mapStatus.length-1].length-1});
        }
        if(mapStatus[0].length>=2) {
            result=checkAndSetPositive(new int[]{0,0},new int[]{0,1});
            if(result!=0) return result;
            checkAndSetNegative(new int[]{mapStatus.length-1,mapStatus[mapStatus.length-1].length-1},
                                new int[]{mapStatus.length-1,mapStatus[mapStatus.length-1].length-2});
        }
        
        while(myStep.size()!=0&&opponentStep.size()!=0){
            int[] mypos=myStep.pollFirst();
            int[] nextpos;
            //하
            if(mypos[0]+1!=mapStatus.length){
                result=checkAndSetPositive(mypos,new int[]{mypos[0]+1,mypos[1]});
                if(result!=0) return result;
            }
            //상
            if(mypos[0]!=0){
                result=checkAndSetPositive(mypos,new int[]{mypos[0]-1,mypos[1]});
                if(result!=0) return result;
            }
            //우
            if(mypos[1]+1!=mapStatus[mypos[0]].length){
                result=checkAndSetPositive(mypos,new int[]{mypos[0],mypos[1]+1});
                if(result!=0) return result;
            }
            //좌
            if(mypos[1]!=0){
                result=checkAndSetPositive(mypos,new int[]{mypos[0],mypos[1]-1});
                if(result!=0) return result;
            }
            
            mypos=opponentStep.pollFirst();
            //하
            if(mypos[0]+1!=mapStatus.length){
                result=checkAndSetNegative(mypos,new int[]{mypos[0]+1,mypos[1]});
                if(result!=0) return result;
            }
            //상
            if(mypos[0]!=0){
                result=checkAndSetNegative(mypos,new int[]{mypos[0]-1,mypos[1]});
                if(result!=0) return result;
            }
            //우
            if(mypos[1]+1!=mapStatus[mypos[0]].length){
                result=checkAndSetNegative(mypos,new int[]{mypos[0],mypos[1]+1});
                if(result!=0) return result;
            }
            //좌
            if(mypos[1]!=0){
                result=checkAndSetNegative(mypos,new int[]{mypos[0],mypos[1]-1});
                if(result!=0) return result;
            }
        }
        return -1;
    }
    
    int checkAndSetPositive(int[] mypos, int[] nextpos){
        if(mapStatus[nextpos[0]][nextpos[1]]==1){
            mapStatus[nextpos[0]][nextpos[1]]=mapStatus[mypos[0]][mypos[1]]+1;
            myStep.add(nextpos);
        }else if(mapStatus[nextpos[0]][nextpos[1]]<0)
            return mapStatus[mypos[0]][mypos[1]]-mapStatus[nextpos[0]][nextpos[1]];
        return 0;
    }
    
    int checkAndSetNegative(int[] mypos, int[] nextpos){
        if(mapStatus[nextpos[0]][nextpos[1]]==1){
            mapStatus[nextpos[0]][nextpos[1]]=mapStatus[mypos[0]][mypos[1]]-1;
            opponentStep.add(nextpos);
        }else if(mapStatus[nextpos[0]][nextpos[1]]>1)
            return mapStatus[nextpos[0]][nextpos[1]]-mapStatus[mypos[0]][mypos[1]];
        return 0;
    }
}
/*
지나는 칸의 수가 필요함
주어진 map을 덮어쓸 수도 있음
bfs(큐) 활용
내 이동 거리(1,2) set
상대 이동 거리(-1,-2) set
내 이동 거리 3 set
상대 -3 set
상하좌우 보고 내가 이동 시 0 or 막힘 -> 이동 안함
1->이동 값 덮음(진짜 1인건 이미 처음 처리함, 다른 걸로 덮어도 상관없음), 큐 push
1이 아닌 양수 -> 이동 안함
음수->음수 절댓값 처리 후 양수 값 합해 반환
*/