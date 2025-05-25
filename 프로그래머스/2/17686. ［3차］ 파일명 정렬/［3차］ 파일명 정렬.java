import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        TreeMap<String,TreeMap<Integer,List<String>>> indexes=new TreeMap<>();
        //HEAD, NUMBER 기수정렬
        for(String fileName:files){
            int headIdx=1;
            while(headIdx<fileName.length()&&
                  !Character.isDigit(fileName.charAt(headIdx)))
                headIdx++;
            String head=fileName.substring(0,headIdx).toLowerCase();
            int numIdx=headIdx;
            while(numIdx<fileName.length()&&
                  Character.isDigit(fileName.charAt(numIdx)))
                numIdx++;
            int num=Integer.parseInt(fileName.substring(headIdx,numIdx));
            if(!indexes.containsKey(head))
                indexes.put(head,new TreeMap<>());
            TreeMap<Integer,List<String>> dep1=indexes.get(head);
            if(!dep1.containsKey(num))
                dep1.put(num,new ArrayList());
            dep1.get(num).add(fileName);
        }
        return indexes.values().stream()
            .flatMap(t->t.values().stream()
                    .flatMap(List::stream))
            .toArray(String[]::new);
    }
}