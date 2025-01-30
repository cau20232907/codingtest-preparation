class Solution {
    private final static int boardSize=5;
    public int solution(String dirs) {
        boolean[][] acrossRoadStat=new boolean[boardSize*2][boardSize*2+1];
        boolean[][] downRoadStat=new boolean[boardSize*2+1][boardSize*2];
        //[x+5][y+5], 길은 값이 작은 쪽에 저장(-1~0 사이 길은 4(-1+5)에 저장)
        int currentX=boardSize,currentY=boardSize;
        //-5,-5가 0,0이 되는 만큼 출발 위치 변경
        int walkedRoad=0; //중복제외 걸은 길 수
        for(byte command:dirs.getBytes())
            switch(command){
                case 'U':{
                    if(currentY!=boardSize*2){
                        walkedRoad+=checkAndSetRoad
                            (downRoadStat,currentX,currentY);
                        currentY++; //나중에 해야 RoadStat에 문제 없음
                    }
                    break;
                }
                case 'D':{
                    if(currentY!=0){
                        currentY--;
                        walkedRoad+=checkAndSetRoad
                            (downRoadStat,currentX,currentY);
                    }
                    break;
                }
                case 'R':{
                    if(currentX!=boardSize*2){
                        walkedRoad+=checkAndSetRoad
                            (acrossRoadStat,currentX,currentY);
                        currentX++; //나중에 해야 RoadStat에 문제 없음
                    }
                    break;
                }
                case 'L':{
                    if(currentX!=0){
                        currentX--;
                        walkedRoad+=checkAndSetRoad
                            (acrossRoadStat,currentX,currentY);
                    }
                    break;
                }
            }
        return walkedRoad;
    }
    
    //byte[]로 받아서 X는 없앨 수도 있으나 사람이 코드를 보기가 어려움
    private byte checkAndSetRoad(boolean[][] roadSet, int X, int Y){
        if(!roadSet[X][Y]){
            roadSet[X][Y]=true;
            return 1;
        }
        else
            return 0;
    }
}