import java.util.*;

class Solution {
    int[][] moves = {{0,1}, {1,1}, {1,0}, {1,-1},
                   {0,-1}, {-1,-1}, {-1,0}, {-1,1}};
    public int solution(int[] arrows) {
        Set<Integer> visited = new HashSet<>();
        // 대각선은 위쪽 출발지 저장
        Set<Integer> leftUpDiagonal = new HashSet<>();
        Set<Integer> rightUpDiagonal = new HashSet<>();
        Set<Long> lines = new HashSet<>();
        
        int answer = 0;
        int currentX = 0;
        int currentY = 0;
        visited.add(getHashcode(0, 0));
        
        // 교점만 세기
        for (int i = 0; i < arrows.length; i++) {
            int direction = arrows[i];
            boolean existedLine = !lines.add(getLineHashByMove(currentX, currentY, direction));
            currentX += moves[direction][0];
            currentY += moves[direction][1];
            
            // 기존에 그어진 선인지 확인
            if (existedLine) {
                // Set.add는 삽입할 데이터가 기존에 없다면 true, 이외 false 반환
                // 따라서 확인 후 따로 삽입할 것 없이 삽입과 동시에 중복 여부 확인 가능
                continue;
            }
            
            // 대각선 처리
            if (direction % 2 == 1 &&
                lines.contains(
                    getLineHashByMove(currentX,
                                      currentY - moves[direction][1],
                                      8 - direction)
                )
               ) {
                answer++;
            }
            
            // 공통 처리
            if (!visited.add(getHashcode(currentX, currentY))) {
                // Set.add는 삽입할 데이터가 기존에 없다면 true, 이외 false 반환
                // 따라서 확인 후 따로 삽입할 것 없이 삽입과 동시에 중복 여부 확인 가능
                answer++;
            }
        }
        return answer;
    }
    
    // 좌표를 Object나 Array로 만들면 Set 연산이 복잡하므로,
    // int의 앞 16bit에 x, 뒤 16bit에 y 저장
    // (Array로 저장시 Set에서 중복이 지워지지 않고,
    //  Object로 만들 시 별도의 equals, hashcode 함수를 만들어야 하나
    //  큰 프로젝트라면 모를까 코딩테스트에서 이는 사치인 데다
    //  hashcode 함수에서도 동일한 내용의 코드를 작성해야 함)
    int getHashcode(int x, int y) {
        return (x << 16) + y;
    }
    
    long getLineHash(int fromHash, int toHash) {
        if (fromHash > toHash) {
            return ((long) fromHash << 32) + toHash;
        } else {
            return ((long) toHash << 32) + fromHash;
        }
    }
    
    long getLineHashByMove(int x, int y, int direction) {
        return getLineHash(getHashcode(x, y),
                           getHashcode(x + moves[direction][0],
                                       y + moves[direction][1]));
    }
}