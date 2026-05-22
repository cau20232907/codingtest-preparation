class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long mid = 0;
        long sum = 0;
        for(int i = 0; i < queue1.length; i++) {
            mid += queue1[i];
        }
        sum = mid;
        for(int i = 0; i < queue2.length; i++) {
            mid += queue2[i];
        }
        if (mid % 2 == 1) {
            return -1;
        }
        mid /= 2;
        
        int operation = 0;
        int addPos = 0;
        int rmPos = 0;
        boolean addAt1 = false;
        boolean rmAt1 = true;
        boolean addFinish = false;
        boolean rmFinish = false;
        
        while(true) {
            if (sum == mid) {
                return operation;
            } else if (sum < mid) {
                if (addFinish) {
                    return -1;
                } else if (addAt1) {
                    sum += queue1[addPos++];
                    if (addPos == queue1.length) {
                        addFinish = true;
                    }
                } else {
                    sum += queue2[addPos++];
                    if (addPos == queue2.length) {
                        addAt1 = true;
                        addPos = 0;
                    }
                }
            } else {
                if (rmFinish) {
                    return -1;
                } else if (rmAt1) {
                    sum -= queue1[rmPos++];
                    if (rmPos == queue1.length) {
                        rmAt1 = false;
                        rmPos = 0;
                    }
                } else {
                    sum -= queue2[rmPos++];
                    if (rmPos == queue2.length) {
                        rmFinish = true;
                    }
                }
            }
            operation++;
        }
    }
}