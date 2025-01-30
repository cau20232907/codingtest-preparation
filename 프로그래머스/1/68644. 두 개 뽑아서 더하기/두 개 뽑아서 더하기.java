import java.util.TreeSet;

class Solution {
    public int[] solution(int[] numbers) {
        TreeSet<Integer> result=new TreeSet<>();
        int frontIdx=0,secondIdx;
        for(frontIdx=0;frontIdx<numbers.length-1;frontIdx++){
            for(secondIdx=frontIdx+1;secondIdx<numbers.length;secondIdx++){
                result.add(numbers[frontIdx]+numbers[secondIdx]);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}