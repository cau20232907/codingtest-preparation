import java.util.*;
import java.util.stream.*;

class Solution {
    public long solution(int[] a, int[][] edges) {
        List<Integer>[] connected=new List[a.length];
        long[] arr=new long[a.length];
        long sum=0;
        for(int i=0;i<a.length;i++){
            connected[i]=new ArrayList<>();
            arr[i]=a[i];
            sum+=a[i];
        }
        if(sum!=0) return -1;
        for(int[] edge:edges){
            connected[edge[0]].add(edge[1]);
            connected[edge[1]].add(edge[0]);
        }
        //root: 0
        Stack<WorkFlow> stack=new Stack<>(); //함수 사용 불가(stackoverflow), 직접 구현
        WorkFlow currentWork=new WorkFlow(0,0); //stack에서 제외
        long answer=0;
        while(true){
            if(currentWork.i==connected[currentWork.current].size()){
                long value=arr[currentWork.current];
                //arr[currentWork.current]=0;
                arr[currentWork.parent]+=value;
                answer+=Math.abs(value);
                if(stack.isEmpty()) return answer;
                else currentWork=stack.pop();
                continue;
            }
            int child=connected[currentWork.current].get(currentWork.i);
            currentWork.i++;
            if(child!=currentWork.parent){
                stack.add(currentWork);
                currentWork=new WorkFlow(child,currentWork.current);
            }
        }
    }
    private class WorkFlow{
        //getter 생략
        final int current;
        final int parent;
        int i;
        WorkFlow(int current, int parent){
            this.current=current;
            this.parent=parent;
            this.i=0;
        }
    }
}
//밑에서부터 올라와야 함
//분할 정복