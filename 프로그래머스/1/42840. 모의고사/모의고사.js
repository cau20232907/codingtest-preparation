function solution(answers) {
    const picks = [
        [1,2,3,4,5],
        [2,1,2,3,2,4,2,5],
        [3,3,1,1,2,2,4,4,5,5],
    ];
    const correct = [0,0,0];
    for(let i=0;i<answers.length;i++){
        for(let j=0;j<picks.length;j++){
            (answers[i]===picks[j][i%picks[j].length]) && (correct[j]++);
        }
    }
    const maxPts=Math.max(...correct);
    const result=[];
    for(let j=0;j<picks.length;j++){
        (maxPts===correct[j])&&(result.push(j+1));
    }
    return result;
}