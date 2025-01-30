import java.util.*;

class Solution {
    int[] isWolf;
    int[][] nextEdges; //info에서 바라보는 자식 node
    public int solution(int[] info, int[][] edges) {
        isWolf=info;
        int answer = 0;
        nextEdges=new int[info.length][];
        for(int i=0;i<edges.length;i++){
            if(nextEdges[edges[i][0]]==null)
                nextEdges[edges[i][0]]=new int[]{edges[i][1]};
            else //if(nextEdges[edges[i][0]].length==1)
                nextEdges[edges[i][0]]=
                new int[]{nextEdges[edges[i][0]][0],edges[i][1]};
        }
        
        Deque<Status> statuses=new ArrayDeque<>();
        Status currentStatus=new Status(0);
        statuses.add(currentStatus);
        while(statuses.size()>0){
            currentStatus=statuses.poll();
            if(currentStatus.getSheeps()>answer)
                answer=currentStatus.getSheeps();
            statuses.addAll(currentStatus.selectOnceAll());
        }
        return answer;
    }
    
    public class Status{
        private int sheeps;
        private int wolves;
        private final Set<Integer> nextAvailableEdges;
        Status(int selectFirst){
            this.sheeps=0;
            this.wolves=0;
            this.nextAvailableEdges=new HashSet<>();
            calculateSelect(selectFirst);
        }
        
        Status(Status beforeStatus, int select){
            //if(!beforeStatus.nextAvailableEdges.contains(select)) throw new RuntimeException();
            this.sheeps=beforeStatus.sheeps;
            this.wolves=beforeStatus.wolves;
            this.nextAvailableEdges=new HashSet<>(beforeStatus.nextAvailableEdges);
            calculateSelect(select);
        }
        
        private void calculateSelect(int select){
            if(isWolf[select]==1){
                this.wolves++;
                if(wolves==sheeps) throw new RuntimeException();
            }else this.sheeps++;
            nextAvailableEdges.remove(select);
            if(nextEdges[select]!=null){
                for(int i:nextEdges[select]){
                    if(isWolf[i]==0) calculateSelect(i);
                    else nextAvailableEdges.add(i);
                }
            }
        }
        
        List<Status> selectOnceAll(){
            List<Status> selected=new ArrayList<>();
            for(int i:nextAvailableEdges){
                try{
                    selected.add(new Status(this,i));
                }catch(RuntimeException e){
                    //nothing
                }
            }
            return selected;
        }
        
        int getSheeps(){
            return sheeps;
        }
    }
}

/*
graph
양이 있으면 무조건 선택, 이후 기록(중간에 끝날 수 있음)
양==늑대 발생시 바로 폐기

*/