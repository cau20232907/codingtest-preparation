function solution(absolutes, signs) {
    let answer=0;
    for(const i in absolutes){
        if(signs[i]) {
            answer+=absolutes[i];
        } else {
            answer-=absolutes[i];
        }
    }
    return answer;
}