class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] keyCount = new int[26];
        for(int i=0; i<keymap.length; i++) {
            char[] key = keymap[i].toCharArray();
            for(int j=0; j<key.length; j++) {
                if(keyCount[key[j] - 'A'] == 0 ||
                   keyCount[key[j] - 'A'] > j + 1) {
                    keyCount[key[j] - 'A'] = j + 1;
                }
            }
        }
        
        int[] answer = new int[targets.length];
        for(int i=0; i<targets.length; i++) {
            char[] key = targets[i].toCharArray();
            int totalCount = 0;
            for(int j=0; j<key.length; j++) {
                if(keyCount[key[j] - 'A'] == 0) {
                    totalCount = -1;
                    break;
                } else {
                    totalCount += keyCount[key[j] - 'A'];
                }
            }
            answer[i] = totalCount;
        }
        return answer;
    }
}