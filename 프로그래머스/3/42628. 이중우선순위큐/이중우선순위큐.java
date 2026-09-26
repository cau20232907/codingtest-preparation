import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        TreeMap<Integer, Integer> queue = new TreeMap<>();
        for (String op: operations) {
            switch (op.charAt(0)) {
                case 'I':
                    int target = Integer.parseInt(op.substring(2));
                    queue.put(target, queue.getOrDefault(target, 0) + 1);
                    break;
                    
                case 'D':
                    if (queue.isEmpty()) {
                        break;
                    }
                    
                    target = switch (Integer.parseInt(op.substring(2))) {
                        case 1 -> queue.lastKey();
                        case -1 -> queue.firstKey();
                        default -> throw new RuntimeException();
                    };
                    
                    int count = queue.get(target);
                    if (count == 1) {
                        queue.remove(target);
                    } else {
                        queue.put(target, count - 1);
                    }
            }
        }
        
        if (queue.isEmpty()) {
            return new int[]{0, 0};
        } else {
            return new int[]{queue.lastKey(), queue.firstKey()};
        }
    }
}