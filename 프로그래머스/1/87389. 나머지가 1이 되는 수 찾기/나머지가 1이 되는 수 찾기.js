function solution(n) {
    var answer = 0;
    n--;
    for(answer = 2; n % answer !== 0; answer++);
    return answer;
}