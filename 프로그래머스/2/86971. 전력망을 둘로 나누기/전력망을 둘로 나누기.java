import java.util.List;
import java.util.ArrayList;

class Solution {
    List<Wire>[] wiresByNode;
    public int solution(int n, int[][] wires) {
        wiresByNode=new List[n];
        Wire[] wiresByClass=new Wire[wires.length];
        for(int i=0;i<n;i++)
            wiresByNode[i]=new ArrayList<>();
        for(int i=0;i<wires.length;i++){
            Wire newWire=new Wire
                (wires[i],wiresByNode[wires[i][0]-1],wiresByNode[wires[i][1]-1]);
            wiresByNode[wires[i][0]-1].add(newWire);
            wiresByNode[wires[i][1]-1].add(newWire);
            wiresByClass[i]=newWire;
        }
        
        int minDiff=n;
        for(int i=0;i<wiresByClass.length;i++){
            //System.out.println(wiresByClass[i]);
            int diff=wiresByClass[i].getDiff();
            if(diff<1) return diff;
            else if(diff<minDiff) minDiff=diff;
        }
        return minDiff;
    }
    
    private class Wire{
        final int node1;
        final int node2;
        int connectedToNode1;
        int connectedToNode2;
        
        Wire(int[] wireArr){
            node1=wireArr[0];
            node2=wireArr[1];
            connectedToNode1=1; //1쪽에 연결
            connectedToNode2=1; //2쪽에 연결
        }
        
        Wire(int[] wireArr, List<Wire> connectedWires1, List<Wire> connectedWires2){
            this(wireArr);
            
            //연결된 노드 확인
            if(!connectedWires1.isEmpty()){
                Wire wireInfo1=connectedWires1.get(0);
                connectedToNode1=
                    wireInfo1.connectedToNode1+wireInfo1.connectedToNode2;
            }
            if(!connectedWires2.isEmpty()){
                Wire wireInfo2=connectedWires2.get(0);
                connectedToNode2=
                    wireInfo2.connectedToNode1+wireInfo2.connectedToNode2;
            }
            
            //연결된 노드 수정(기존 다른 wire 값)
            updateWireInfo(connectedWires1,node1,connectedToNode2);
            updateWireInfo(connectedWires2,node2,connectedToNode1);
        }
        
        private void updateWireInfo(List<Wire> targets, int nodeNo, int value){
            for(int i=0;i<targets.size();i++){
                Wire eachWire=targets.get(i);
                if(eachWire==this) continue;
                else if(eachWire.node1==nodeNo){
                    eachWire.connectedToNode1+=value;
                    eachWire.updateWireInfo(wiresByNode[eachWire.node2-1],eachWire.node2,value);
                }
                else{
                    eachWire.connectedToNode2+=value;
                    eachWire.updateWireInfo(wiresByNode[eachWire.node1-1],eachWire.node1,value);
                }
            }
        }
        
        int getDiff(){
            int diff=connectedToNode1-connectedToNode2;
            if(diff<0) return connectedToNode2-connectedToNode1;
            //곱셈보다 뺄셈 성능이 좋음
            return diff;
        }
        
        @Override
        public String toString(){
            return "["+node1+", "+node2+"], connected:["+connectedToNode1+", "+connectedToNode2+"]";
        }
    }
}

/*
cycle 없음
wire의 수는 n-1
wire에 이거와 연결되는 노드 수를 같이 저장할 수 있음

wire 하나씩 보며 양쪽 노드에 연결된 노드 수 세기
각 선을 자를 때 분할되는 걸 측정하면 됨
*/