function solution(n) {
    return BigInt([...(n+"")].sort((a,b)=>b-a).join(""));
}