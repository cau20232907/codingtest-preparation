import java.util.*;

class Solution {
    public int solution(String[] board) {
        int[][] board2d = new int[board.length][board[0].length()];
        Set<Point> current = new HashSet<>();
        for(int i = 0; i < board.length; i++) {
            char[] line = board[i].toCharArray();
            for(int j = 0; j < line.length; j++) {
                board2d[i][j] = switch(line[j]) {
                        case '.' -> 0;
                        case 'D' -> -1;
                        case 'G' -> -2;
                        case 'R' -> {
                            current.add(new Point(i, j));
                            yield 0;
                        }
                        default -> throw new RuntimeException();
                };
            }
        }
        
        Set<Point> next = new HashSet<>();
        for(int move = 1; current.size() != 0; move++) {
            for(Point point:current) {
                //[-1,0]
                int movedX = point.x;
                while(movedX > 0 && board2d[movedX - 1][point.y] != -1) {
                    movedX--;
                }
                switch(board2d[movedX][point.y]) {
                    case -2: // G
                        return move;
                    case 0:
                        next.add(new Point(movedX, point.y));
                        board2d[movedX][point.y] = move;
                }
                
                //[+1,0]
                movedX = point.x;
                while(movedX + 1 < board2d.length && board2d[movedX + 1][point.y] != -1) {
                    movedX++;
                }
                switch(board2d[movedX][point.y]) {
                    case -2: // G
                        return move;
                    case 0:
                        next.add(new Point(movedX, point.y));
                        board2d[movedX][point.y] = move;
                }
                
                //[0,-1]
                int movedY = point.y;
                while(movedY > 0 && board2d[point.x][movedY - 1] != -1) {
                    movedY--;
                }
                switch(board2d[point.x][movedY]) {
                    case -2: // G
                        return move;
                    case 0:
                        next.add(new Point(point.x, movedY));
                        board2d[point.x][movedY] = move;
                }
                
                //[0,+1]
                movedY = point.y;
                while(movedY + 1 < board2d[0].length && board2d[point.x][movedY + 1] != -1) {
                    movedY++;
                }
                switch(board2d[point.x][movedY]) {
                    case -2: // G
                        return move;
                    case 0:
                        next.add(new Point(point.x, movedY));
                        board2d[point.x][movedY] = move;
                }
            }
            Set<Point> temp = current;
            current = next;
            next = temp;
            next.clear();
        }
        return -1;
    }
    
    class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}