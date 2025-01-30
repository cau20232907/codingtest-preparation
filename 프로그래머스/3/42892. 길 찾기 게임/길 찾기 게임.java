import java.util.*;

class Solution {
    //클래스 변수 설정만으로 최적화가 가능한 건 뺌(이걸 쓰지 않으면 재귀를 써야 하는 것 등)
    //Map<Integer, Node> mapByX=new HashMap<>();
    Set<TreeWithRange> queueWaitingNode=new HashSet<>(); //중간에서 뽑아 써야 하기에 Queue 사용 불가
    int[] result;
    int resultOrder;
    
    public int[][] solution(int[][] nodeinfo) {
        Map<Integer, List<Node>> mapByY=new TreeMap<>();
        for(int i=0;i<nodeinfo.length;i++){
            Node target=new Node(i+1,nodeinfo[i][0],nodeinfo[i][1]);
            //mapByX.put(target.x,target);
            if(mapByY.containsKey(target.y))
                mapByY.get(target.y).add(target);
            else{
                List<Node> toPutY=new ArrayList<>();
                toPutY.add(target);
                mapByY.put(target.y, toPutY);
            }
        }
        
        TreeWithRange tree=new TreeWithRange(0x80000000, 0x7FFFFFFF); //int min, max 꺼내는 방법 까먹음
        int[] YCoords=mapByY.keySet().stream().sorted((i,j)->j.compareTo(i)).mapToInt(Integer::intValue).toArray();
        tree.setNode(mapByY.get(YCoords[0]).get(0));
        
        for(int i=1;i<YCoords.length;i++){
            for(Node leveledNode:mapByY.get(YCoords[i])){
                TreeWithRange targetPos=queueWaitingNode.stream().filter(treeNode->treeNode.isSetAbleByX(leveledNode)).max((j,k)->Integer.compare(j.minX,k.minX)).get();
                //max는 필요 없고 남은 하나를 꺼내오면 되는데 그걸 기억 못해서 이걸로 대체
                targetPos.setNode(leveledNode);
            }
        }
        
        int[][] answer=new int[2][nodeinfo.length];
        result=answer[0];
        resultOrder=0;
        tree.addPreorderResult();
        result=answer[1];
        resultOrder=0;
        tree.addPostorderResult();
        
        return answer;
    }
    
    //getter 생략
    private class Node{
        final int number;
        final int x;
        final int y;
        
        Node(int number, int x, int y){
            this.number=number;
            this.x=x;
            this.y=y;
        }
        
        @Override
        public int hashCode(){
            return x;
        }
    }
    
    private class TreeWithRange{
        final int minX;
        final int maxX;
        Node node;
        TreeWithRange leftNode;
        TreeWithRange rightNode;
        
        TreeWithRange(int minX, int maxX){
            this.minX=minX;
            this.maxX=maxX;
        }
        
        void setNode(Node node){
            //유효성 검증 생략
            this.node=node;
            queueWaitingNode.remove(this);
            leftNode=new TreeWithRange(this.minX,node.x-1);
            queueWaitingNode.add(leftNode);
            rightNode=new TreeWithRange(node.x+1,this.maxX);
            queueWaitingNode.add(rightNode);
        }
        
        boolean isSetAbleByX(Node node){
            return minX<=node.x&&maxX>=node.x;
        }
        
        void addPreorderResult(){
            if(node!=null){
                result[resultOrder++]=node.number;
                leftNode.addPreorderResult();
                rightNode.addPreorderResult();
            }
        }
        
        void addPostorderResult(){
            if(node!=null){
                leftNode.addPostorderResult();
                rightNode.addPostorderResult();
                result[resultOrder++]=node.number;
            }
        }
        
        @Override
        public int hashCode(){
            return minX;
        }
    }
}

/*
x좌표를 id로 설정 가능
x좌표 min, max 설정해서 subtree 구상 가능
y좌표 기준 Map도 설정해서 레벨당 노드도 뽑아야 함
y좌표 기준 Map에서 최대 level을 가진 노드를 뽑아 Root로 삼음
다음으로 작은 y좌표의 노드를 뽑아 좌우를 나눔(최대, 최소 데이터 저장 필요)
하나밖에 없다면 좌우 중 하나는 범위만 저장하고 비운 후 다음 level의 노드가 해당 범위 이내이면 이를 저장
-> x좌표 범위를 지정할 필요가 있음, 또는 Map을 나누던가
*/