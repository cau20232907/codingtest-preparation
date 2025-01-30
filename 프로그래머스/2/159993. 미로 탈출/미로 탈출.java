import java.util.*;

class Solution {
    Position[] moves=new Position[]{new Position(1,0), new Position(-1,0), new Position(0,1), new Position(0,-1)};
    int[][] mapArr;
    int sizeX;
    int sizeY;
    public int solution(String[] maps) {
        ArrayDeque<Position> dfs=new ArrayDeque<>();
        sizeX=maps.length;
        sizeY=maps[0].length();
        
        mapArr=new int[sizeX][sizeY];
        //map 값 넣기
        for(int i=0;i<maps.length;i++){
            byte[] line=maps[i].getBytes();
            for(int j=0;j<line.length;j++){
                switch(line[j]){
                    case 'X': {
                        mapArr[i][j]=-1;
                        break;
                    }
                    case 'S': {
                        mapArr[i][j]=-2;
                        break;
                    }
                    //case 'O': break; //0
                    case 'L':{
                        dfs.add(new Position(i,j));
                        mapArr[i][j]=1;
                        break;
                    }
                    case 'E':{
                        mapArr[i][j]=-3;
                        //break;
                    }
                }
            }
        }
        
        int StoL=0; //unsigned, 0이면 못 찾은 것
        int LtoE=0; //unsigned, 0이면 못 찾은 것
        Position currentPos, nextPos;
        int currentMapData;
        do {
            currentPos=dfs.poll();
            currentMapData=currentPos.getMapData();
            for(int i=0;i<moves.length;i++){
                nextPos=new Position(currentPos,moves[i]);
                if(!nextPos.valid()) continue;
                int mapData=nextPos.getMapData();
                //if(mapData==-1);
                if(mapData==0){
                    nextPos.setMapData(currentMapData+1);
                    dfs.add(nextPos);
                }
                else if(mapData==-2&&StoL==0){ //시작과 만남
                    StoL=currentMapData;
                    nextPos.setMapData(currentMapData+1);
                    dfs.add(nextPos);
                }
                else if(mapData==-3&&LtoE==0){ //출구와 만남
                    LtoE=currentMapData;
                    nextPos.setMapData(currentMapData+1);
                    dfs.add(nextPos);
                }
            }
        } while((StoL==0||LtoE==0)&&(!dfs.isEmpty()));
        if(StoL==0||LtoE==0) return -1;
        else return StoL+LtoE;
    }
    
    private class Position{
        final int x;
        final int y;
        
        Position(int x, int y){
            this.x=x;
            this.y=y;
        }
        
        Position(Position current, Position move){
            this.x=current.x+move.x;
            this.y=current.y+move.y;
        }
        
        boolean valid(){
            return x>=0&&y>=0&&x<sizeX&&y<sizeY;
        }
        
        int getMapData(){
            return mapArr[x][y];
        }
        
        void setMapData(int to){
            mapArr[x][y]=to;
        }
    }
}