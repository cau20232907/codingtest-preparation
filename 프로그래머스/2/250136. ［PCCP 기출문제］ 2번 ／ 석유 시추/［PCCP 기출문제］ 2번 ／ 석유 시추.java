import java.util.*;

class Solution {
    public int solution(int[][] land) {
        //이전 칸과 비교한 차이점만 저장
        int[] obtainableDiff = new int[land[0].length + 1];
        
        for(int i = 0; i < land.length; i++) {
            for(int j = 0; j < land[i].length; j++) {
                if (land[i][j] == 1) {
                    ArrayDeque<Point> nextPoints = new ArrayDeque<>();
                    nextPoints.add(new Point(i,j));
                    int minPos = j;
                    int maxPos = j;
                    int area = 0;
                    while(!nextPoints.isEmpty()) {
                        Point nextPoint = nextPoints.pollFirst();
                        int acr = nextPoint.acr;
                        int dwn = nextPoint.dwn;
                        if(acr < 0 || acr >= land.length ||
                           dwn < 0 || dwn >= land[acr].length ||
                            land[acr][dwn] == 0
                        ) {
                            continue;
                        }
                        
                        land[acr][dwn] = 0; // 방문 표시
                        area++;
                        if (minPos > dwn) {
                            minPos = dwn;
                        } else if (maxPos < dwn) {
                            maxPos = dwn;
                        }
                        
                        nextPoints.add(new Point(acr+1,dwn));
                        nextPoints.add(new Point(acr-1,dwn));
                        nextPoints.add(new Point(acr,dwn+1));
                        nextPoints.add(new Point(acr,dwn-1));
                    }
                    obtainableDiff[minPos] += area;
                    obtainableDiff[maxPos + 1] -= area;
                }
            }
        }
        
        int maxValue = obtainableDiff[0];
        int currentValue = maxValue;
        for(int i = 1; i < land[0].length; i++) {
            currentValue += obtainableDiff[i];
            if (maxValue < currentValue) {
                maxValue = currentValue;
            }
        }
        return maxValue;
    }
    
    class Point {
        int acr;
        int dwn;
        
        Point(int acr, int dwn) {
            this.acr = acr;
            this.dwn = dwn;
        }
    }
}