class Solution {
    public String solution(int[] numbers, String hand) {
        char[] answer = new char[numbers.length];
        int leftPos = 4;
        int rightPos = 4;
        boolean leftCenter = false;
        boolean rightCenter = false;
        
        for(int i = 0; i < numbers.length; i++) {
            switch(numbers[i]) {
                case 1:
                case 4:
                case 7:
                    leftPos = numbers[i] / 3 + 1;
                    leftCenter = false;
                    answer[i] = 'L';
                    break;
                case 3:
                case 6:
                case 9:
                    rightPos = numbers[i] / 3;
                    rightCenter = false;
                    answer[i] = 'R';
                    break;
                case 2:
                case 5:
                case 8:
                    int leftDist = Math.abs(leftPos - (numbers[i] / 3 + 1));
                    if (!leftCenter) {
                        leftDist++;
                    }
                    int rightDist = Math.abs(rightPos - (numbers[i] / 3 + 1));
                    if (!rightCenter) {
                        rightDist++;
                    }
                    if (leftDist < rightDist ||
                        (leftDist == rightDist && hand.equals("left"))) {
                        leftPos = numbers[i] / 3 + 1;
                        leftCenter = true;
                        answer[i] = 'L';
                    } else {
                        rightPos = numbers[i] / 3 + 1;
                        rightCenter = true;
                        answer[i] = 'R';
                    }
                    break;
                case 0:
                    leftDist = Math.abs(leftPos - 4);
                    if (!leftCenter) {
                        leftDist++;
                    }
                    rightDist = Math.abs(rightPos - 4);
                    if (!rightCenter) {
                        rightDist++;
                    }
                    if (leftDist < rightDist ||
                        (leftDist == rightDist && hand.equals("left"))) {
                        leftPos = 4;
                        leftCenter = true;
                        answer[i] = 'L';
                    } else {
                        rightPos = 4;
                        rightCenter = true;
                        answer[i] = 'R';
                    }
            }
        }
        
        return new String(answer);
    }
}