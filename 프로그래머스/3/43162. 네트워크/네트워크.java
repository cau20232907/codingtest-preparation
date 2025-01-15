import java.util.stream.IntStream;
import java.util.Arrays;

class Solution {
    int[] root;
    public int solution(int n, int[][] computers) {
        root=IntStream.range(0,n).toArray();
        for(int i=0;i<computers.length;i++){
            for(int j=i+1;j<computers[i].length;j++){
                if(computers[i][j]==1)
                    setRoot(i,j);
            }
        }
        
        for(int i=1;i<computers.length;i++) getRoot(i); //최종 업데이트
        
        return Arrays.stream(root).distinct().toArray().length;
    }
    
    private void setRoot(final int idx1, final int idx2){
        int root1=getRoot(idx1);
        int root2=getRoot(idx2);
        if(root1>root2){
            root[root1]=root2;
        }
        if(root1<root2){
            root[root2]=root1;
        }
        //동일하면 작업 없음
    }
    
    private int getRoot(final int idx){
        if(root[idx]==idx) return idx;
        return root[idx]=getRoot(root[idx]);
    }
}

/*
1부터 훑어 그거 만들기
만들고 전체 n 훑어 root 변경
distinct count
*/