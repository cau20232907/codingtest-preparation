import java.util.*;

class Solution {
    public long[] solution(long k, long[] room_number) {
        Map<Long, Long> nextRoom = new HashMap<>();
        long[] answer = new long[room_number.length];
        Set<Long> nextRoomChange = new HashSet<>();
        for (int i = 0; i < room_number.length; i++) {
            long currentRoomNo = room_number[i];
            while (nextRoom.containsKey(currentRoomNo)) {
                nextRoomChange.add(currentRoomNo);
                currentRoomNo = nextRoom.get(currentRoomNo);
            }
            answer[i] = currentRoomNo;
            nextRoomChange.add(currentRoomNo);
            currentRoomNo++;
            while (nextRoom.containsKey(currentRoomNo)) {
                nextRoomChange.add(currentRoomNo);
                currentRoomNo = nextRoom.get(currentRoomNo);
            }
            final long nextRoomNo = currentRoomNo;
            nextRoomChange.forEach(j -> nextRoom.put(j, nextRoomNo));
            nextRoomChange.clear();
        }
        return answer;
    }
}