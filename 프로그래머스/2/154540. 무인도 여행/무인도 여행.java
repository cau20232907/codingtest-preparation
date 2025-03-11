import java.util.*;

class Solution {
    public int[] solution(String[] maps) {
        List<Integer> result=new ArrayList<>();
        byte[][] status=Arrays.stream(maps).map(String::getBytes)
            .toArray(byte[][]::new);
        Stack<int[]> dfs=new Stack<>();
        for(int i=0;i<status.length;i++){
            for(int j=0;j<status[i].length;j++){
                if(status[i][j]=='X') continue;
                int current=0;
                do {
                    current+=status[i][j]-'0';
                    status[i][j]='X';
                    if(i+1<status.length&&status[i+1][j]!='X')
                        dfs.add(new int[]{i+1,j});
                    j++;
                } while(j<status[i].length&&status[i][j]!='X');
                //dfs
                while(!dfs.isEmpty()){
                    int[] pos=dfs.pop();
                    if(status[pos[0]][pos[1]]=='X') continue;
                    current+=status[pos[0]][pos[1]]-'0';
                    status[pos[0]][pos[1]]='X';
                    if(pos[0]+1<status.length&&status[pos[0]+1][pos[1]]!='X')
                        dfs.add(new int[]{pos[0]+1,pos[1]});
                    if(pos[1]+1<status[pos[0]].length&&status[pos[0]][pos[1]+1]!='X')
                        dfs.add(new int[]{pos[0],pos[1]+1});
                    if(pos[0]>0&&status[pos[0]-1][pos[1]]!='X')
                        dfs.add(new int[]{pos[0]-1,pos[1]});
                    if(pos[1]>0&&status[pos[0]][pos[1]-1]!='X')
                        dfs.add(new int[]{pos[0],pos[1]-1});
                }
                result.add(current);
            }
        }
        if(result.isEmpty()) result.add(-1);
        return result.stream().mapToInt(Integer::intValue)
            .sorted().toArray();
    }
}