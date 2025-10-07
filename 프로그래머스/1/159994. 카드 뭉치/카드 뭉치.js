function solution(cards1, cards2, goal) {
    for(const value of goal){
        if(cards1.length!==0&&value===cards1[0]){
            cards1.shift();
        }
        else if(cards2.length!==0&&value===cards2[0]){
            cards2.shift();
        }
        else {
            return "No";
        }
    }
    return "Yes";
}