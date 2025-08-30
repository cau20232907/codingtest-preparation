function solution(progresses, speeds) {
    const result = [];
    let currentDay=Math.ceil((100-progresses[0])/speeds[0]);
    let currentCount=1;
    for(let i=1;i<progresses.length;i++){
        let day=Math.ceil((100-progresses[i])/speeds[i]);
        if(currentDay>=day) currentCount++;
        else {
            result.push(currentCount);
            currentCount=1;
            currentDay=day;
        }
    }
    result.push(currentCount);
    return result;
}