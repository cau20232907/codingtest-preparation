import java.util.*;

class Solution {
    public List<Integer> solution(String msg) {
        Map<String, Integer> dictinary = new HashMap<>();
        for(int i = 0; i < 26; i++) {
            dictinary.put(""+(char)('A'+i), i + 1);
        }
        int nextNum = 27;
        char[] chars = msg.toCharArray();
        List<Integer> answer = new ArrayList<>(chars.length);
        
        for(int pos = 0; pos < chars.length;) {
            int wordLen = 1;
            StringBuilder word = new StringBuilder();
            word.append(chars[pos]);
            while(pos + wordLen < chars.length) {
                word.append(chars[pos + wordLen]);
                if (!dictinary.containsKey(word.toString())) {
                    word.delete(word.length() - 1, word.length());
                    break;
                }
                wordLen++;
            }
            answer.add(dictinary.get(word.toString()));
            if(pos + wordLen < chars.length) {
                word.append(chars[pos + wordLen]);
                dictinary.put(word.toString(), nextNum++);
            }
            pos += wordLen;
        }
        
        return answer;
    }
}