class Solution {
    public int solution(String[] words) {
        LetterTree letterTree = new LetterTree();
        for (String word: words) {
            char[] ch = word.toCharArray();
            LetterTree currentNode = letterTree;
            currentNode.wordCount++;
            for (int i = 0; i < ch.length; i++) {
                LetterTree nextNode = currentNode.tree[(int) ch[i] - 'a'];
                if (nextNode == null) {
                    nextNode = new LetterTree();
                    currentNode.tree[(int) ch[i] - 'a'] = nextNode;
                }
                currentNode = nextNode;
                currentNode.wordCount++;
            }
            currentNode.terminal = true;
        }
        
        return letterTree.getCost();
    }
    
    class LetterTree {
        LetterTree[] tree;
        int wordCount;
        boolean terminal;
        
        LetterTree() {
            tree = new LetterTree[26];
            wordCount = 0;
            terminal = false;
        }
        
        int getCost() {
            if (wordCount == 1) {
                return 0;
            }
            
            int totalCost = 0;
            for (int i = 0; i < tree.length; i++) {
                if (tree[i] != null) {
                    totalCost += tree[i].getCost();
                }
            }
            
            if (terminal) {
                totalCost--;
            }
            return totalCost + wordCount;
        }
    }
}